package sn.isi.bookservice.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookDTO {
    private Integer id;
    @NotBlank(message = "Le titre est obligatoire")
    private String titre;
    @NotBlank(message = "L'auteur est obligatoire")
    private String auteur;
    @NotNull
    @Positive
    private Double prix;
    private boolean disponible;


}
