package sn.isi.memberservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.memberservice.dtos.MemberDTO;
import sn.isi.memberservice.entity.Member;
import sn.isi.memberservice.exception.EntityExistsException;
import sn.isi.memberservice.exception.MemberNotFoundException;
import sn.isi.memberservice.exception.ResourceNotFoundException;
import sn.isi.memberservice.mapper.MembreMapper;
import sn.isi.memberservice.repository.MemberRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MembreServiceImpl implements IMembre {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public MemberDTO saveMember(MemberDTO memberDTO) {
        if (memberRepository.existsByEmail(memberDTO.getEmail())) {
            throw new EntityExistsException("Un membre avec cet email existe déjà");
        }
        Member membre = MembreMapper.toEntity(memberDTO);
        if (membre.getDateInscription() == null) {
            membre.setDateInscription(java.time.LocalDate.now());
        }
        Member savedMembre = memberRepository.save(membre);
        return MembreMapper.toDTO(savedMembre);
    }

    @Override
    @Transactional(readOnly = true)
    public MemberDTO getMemberById(Integer id) {
        Member membre = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Membre non trouvé avec l'id : " + id));
        return MembreMapper.toDTO(membre);
    }

    @Override
    @Transactional(readOnly = true)
    public MemberDTO getMemberByEmail(String email) {
        Member membre = memberRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Membre non trouvé avec l'email : " + email));
        return MembreMapper.toDTO(membre);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MemberDTO> getAllMembers() {
        return memberRepository.findAll().stream()
                .map(MembreMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MemberDTO updateMember(Integer id, MemberDTO memberDTO) {
        Member existingMembre = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Membre non trouvé avec l'id : " + id));

        existingMembre.setNom(memberDTO.getNom());
        existingMembre.setPrenom(memberDTO.getPrenom());
        existingMembre.setTelephone(memberDTO.getTelephone());
        existingMembre.setActif(memberDTO.isActif());
        
        if (!existingMembre.getEmail().equals(memberDTO.getEmail()) && memberRepository.existsByEmail(memberDTO.getEmail())) {
             throw new EntityExistsException("Un autre membre avec cet email existe déjà");
        }
        existingMembre.setEmail(memberDTO.getEmail());

        Member updatedMembre = memberRepository.save(existingMembre);
        return MembreMapper.toDTO(updatedMembre);
    }

    @Override
    @Transactional
    public void deleteMember(Integer id) {
        if (!memberRepository.existsById(id)) {
            throw new ResourceNotFoundException("Membre non trouvé avec l'id : " + id);
        }
        memberRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void activateMember(Integer id) {
        Member membre = memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("Membre non trouvé avec l'id : " + id));
        membre.setActif(true);
        memberRepository.save(membre);
    }

    @Override
    @Transactional
    public void deactivateMember(Integer id) {
        Member membre = memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("Membre non trouvé avec l'id : " + id));
        membre.setActif(false);
        memberRepository.save(membre);
    }
}
