package sn.isi.bookservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.isi.bookservice.dtos.BookDTO;
import sn.isi.bookservice.dtos.MemberDTO;
import sn.isi.bookservice.service.IBookService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {
    private final IBookService bookService;

    @PostMapping
    public ResponseEntity<BookDTO> create(@Valid @RequestBody BookDTO book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(book));
    }
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> update(@PathVariable Integer id, @Valid @RequestBody BookDTO book) {
        return ResponseEntity.ok(bookService.update(id, book));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(bookService.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<BookDTO>> getAll() {
        return ResponseEntity.ok(bookService.getAll());
    }
    @GetMapping("/available")
    public ResponseEntity<List<BookDTO>> getAvailable() {
        return ResponseEntity.ok(bookService.getAvailable());
    }
    @GetMapping("/by-author/{auteur}")
    public ResponseEntity<List<BookDTO>> getByAuthor(@PathVariable String auteur) {
        return ResponseEntity.ok(bookService.getByAuthor(auteur));
    }
    @GetMapping("/byMember/{id}")
    public ResponseEntity<MemberDTO> getByMember(@PathVariable Integer id) {
        return ResponseEntity.ok(bookService.getMemberbyID(id));
    }
}
