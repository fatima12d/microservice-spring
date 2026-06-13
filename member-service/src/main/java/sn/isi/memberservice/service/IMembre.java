package sn.isi.memberservice.service;

import sn.isi.memberservice.dtos.MemberDTO;

import java.util.List;

public interface IMembre {
    MemberDTO saveMember(MemberDTO memberDTO);
    MemberDTO getMemberById(Integer id);
    MemberDTO getMemberByEmail(String email);
    List<MemberDTO> getAllMembers();
    MemberDTO updateMember(Integer id, MemberDTO memberDTO);
    void deleteMember(Integer id);
    void activateMember(Integer id);
    void deactivateMember(Integer id);
}
