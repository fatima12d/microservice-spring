package sn.isi.bookservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidBookPriceException extends RuntimeException {
    public InvalidBookPriceException(String message) {
        super(message);
    }
}
