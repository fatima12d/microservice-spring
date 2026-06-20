package sn.isi.loanservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sn.isi.loanservice.dtos.BookDTO;

@FeignClient(
        name = "book-service",
        path = "/api/books"
)
public interface BookClient {
    @GetMapping("/{id}")
    BookDTO getById(@PathVariable("id") Integer id);

    @PutMapping("/{id}")
    BookDTO update(@PathVariable("id") Integer id, @RequestBody BookDTO book);

}
