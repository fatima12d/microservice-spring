package sn.isi.memberservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "membres")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom", length = 100, nullable = false)
    private String nom;

    @Column(name = "prenom", length = 100, nullable = false)
    private String prenom;

    @Column(name = "email", length = 150, nullable = false, unique = true)
    private String email;

    @Column(name = "telephone", length = 20)
    private String telephone;

    @Column(name = "date_inscription", nullable = false)
    private LocalDate dateInscription;

    @Column(name = "actif", nullable = false)
    private boolean actif;

}
