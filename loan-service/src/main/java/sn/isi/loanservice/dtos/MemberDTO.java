package sn.isi.loanservice.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MemberDTO {
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private LocalDate dateInscription;

    private boolean actif;
}
