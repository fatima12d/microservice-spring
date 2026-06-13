package sn.isi.bookservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sn.isi.bookservice.Exception.BookNotFoundException;
import sn.isi.bookservice.dtos.BookDTO;
import sn.isi.bookservice.entity.Book;
import sn.isi.bookservice.mapper.BookMapper;
import sn.isi.bookservice.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService {

    private final BookRepository bookRepository;

    @Override
    public BookDTO save(BookDTO book) {
        log.info("Start create book  services {}", book);
        return BookMapper.toDTO(bookRepository.save(BookMapper.toEntity(book)));
    }

    @Override
    public BookDTO update(Integer id, BookDTO book) {
        if (getById(id) != null) {
            book.setId(id);
        }
        return BookMapper.toDTO(bookRepository.save(BookMapper.toEntity(book)));
    }

    @Override
    public void delete(Integer id) {
        getById(id);
        bookRepository.deleteById(id);
    }

    @Override
    public BookDTO getById(Integer id) {
        Optional<Book> book = Optional.of(bookRepository.findById(id).orElseThrow(
                () -> new BookNotFoundException("id n'existe pas")
        ));
        return BookMapper.toDTO(book.get());
    }

    @Override
    public List<BookDTO> getAll() {
        return bookRepository.findAll().stream().map(BookMapper::toDTO).toList();
    }

    @Override
    public List<BookDTO> getAvailable() {
        return bookRepository.findByAvailable(true).stream().map(BookMapper::toDTO).toList();
    }

    @Override
    public List<BookDTO> getByAuthor(String auteur) {
        return bookRepository.findByAuteurContainingIgnoreCase(auteur).stream()
                .map(BookMapper::toDTO)
                .toList();
    }
}
