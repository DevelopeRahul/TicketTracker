package com.gl.TicketTracker.Exception;
import com.gl.TicketTracker.Exception.TicketNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler(TicketNotFoundException.class)
    public ResponseEntity<String> handleTicketNotFoundException(TicketNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}


