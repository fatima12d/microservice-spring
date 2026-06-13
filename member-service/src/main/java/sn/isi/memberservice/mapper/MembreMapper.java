package sn.isi.memberservice.mapper;

import sn.isi.memberservice.dtos.MemberDTO;
import sn.isi.memberservice.entity.Member;
public class MembreMapper {
    public static MemberDTO toDTO (Member membre) {

        return MemberDTO.builder().
                id(membre.getId()).
                nom(membre.getNom()).
                prenom(membre.getPrenom()).
                email(membre.getEmail()).
                telephone(membre.getTelephone()).
                dateInscription(membre.getDateInscription()).
                actif(membre.isActif()).
                build();

    }


    public static Member toEntity (MemberDTO membre) {
        return Member.builder().
                id(membre.getId()).
                nom(membre.getNom()).
                prenom(membre.getPrenom()).
                email(membre.getEmail()).
                telephone(membre.getTelephone()).
                dateInscription(membre.getDateInscription()).
                actif(membre.isActif()).
                build();


    }
}
