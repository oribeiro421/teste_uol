package tavin.uol.jogadorcadastro.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.xml.sax.SAXException;
import tavin.uol.jogadorcadastro.dto.ExceptionDTO;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionDTO> nullableThret(ConstraintViolationException exception){
        ExceptionDTO dto = new ExceptionDTO("Valor não pode ser null", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<ExceptionDTO> jsonListThret(JsonProcessingException exception){
        ExceptionDTO dto =
                new ExceptionDTO("Lista dos vingadores chegou ao fim", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({ParserConfigurationException.class, IOException.class, SAXException.class})
    public ResponseEntity<ExceptionDTO> xmlListThret(Exception exception){
        ExceptionDTO dto =
                new ExceptionDTO("Lista ds Liga da justiça chegou ao fim", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
