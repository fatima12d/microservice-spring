package sn.isi.bookservice.service;

import sn.isi.bookservice.dtos.BookDTO;
import sn.isi.bookservice.dtos.MemberDTO;

import java.util.List;

public interface IBookService {
    BookDTO save(BookDTO book);
    BookDTO update(Integer id, BookDTO book);
    void delete(Integer id);
    BookDTO getById(Integer id);
    List<BookDTO> getAll();
    List<BookDTO> getAvailable();
    List<BookDTO> getByAuthor(String auteur);

    MemberDTO getMemberbyID(Integer id);
}
