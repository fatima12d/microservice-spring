package sn.isi.bookservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titre", length = 100, nullable = false, unique = true)
    private String title;

    @Column(name = "auteur", length = 100, nullable = false)
    private String auteur;

    @Column(name = "prix", nullable = false)
    private Double prix;

    @Column(name = "available", nullable = false)
    private boolean available;


}
