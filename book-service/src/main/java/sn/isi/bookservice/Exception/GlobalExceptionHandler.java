package sn.isi.bookservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleBookNotFoundException(BookNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidBookPriceException.class)
    public ResponseEntity<Map<String, String>> handleInvalidBookPriceException(InvalidBookPriceException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(feign.FeignException.class)
    public ResponseEntity<Map<String, String>> handleFeignException(feign.FeignException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", "Erreur de communication avec le service externe.");
        error.put("status", String.valueOf(ex.status()));
        error.put("details", ex.getMessage());
        
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (ex.status() == 404) {
            error.put("message", "Le membre recherché n'existe pas dans le service membre.");
            status = HttpStatus.NOT_FOUND;
        } else if (ex.status() > 0) {
            status = HttpStatus.resolve(ex.status()) != null ? HttpStatus.resolve(ex.status()) : HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(error, status);
    }
}
