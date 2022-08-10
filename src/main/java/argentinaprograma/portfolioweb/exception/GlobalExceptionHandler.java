package argentinaprograma.portfolioweb.exception;

import argentinaprograma.portfolioweb.dto.ErrorDetallesDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

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

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();

            errores.put(fieldName, message);
        });

        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }
}
