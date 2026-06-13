package sn.isi.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.isi.bookservice.entity.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    Optional<Book> findByTitle(String title);
    List<Book> findByAvailable(boolean available);
    List<Book> findByAuteurContainingIgnoreCase(String auteur);

}
