package argentinaprograma.portfolioweb.exception;

import argentinaprograma.portfolioweb.dto.ErrorDetallesDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetallesDTO> resourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
        ErrorDetallesDTO errorDetallesDTO = new ErrorDetallesDTO(new Date(), exception.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorDetallesDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetallesDTO> globalException(Exception exception, WebRequest request) {
        ErrorDetallesDTO errorDetallesDTO = new ErrorDetallesDTO(new Date(), exception.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorDetallesDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
