package sn.isi.bookservice.mapper;

import sn.isi.bookservice.dtos.BookDTO;
import sn.isi.bookservice.entity.Book;

public class BookMapper {
    public static BookDTO toDTO(Book b) {
        return BookDTO.builder()
                .id(b.getId()).titre(b.getTitle())
                .auteur(b.getAuteur()).prix(b.getPrix())
                .disponible(b.isAvailable()).build();
    }
    public static Book toEntity(BookDTO d) {
        return Book.builder()
                .id(d.getId()).title(d.getTitre())
                .auteur(d.getAuteur()).prix(d.getPrix())
                .available(d.isDisponible()).build();
    }

}
