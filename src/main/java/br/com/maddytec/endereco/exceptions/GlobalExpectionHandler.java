package br.com.maddytec.endereco.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExpectionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EnderecoNotFoundException.class)
    public final ResponseEntity<Object> handleAllExceptions(EnderecoNotFoundException exception) {
        Map<String, Object> map = new HashMap<>();
        map.put("error", exception.getMessage());
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EnderecoBadRequestException.class)
    public final ResponseEntity<Object> handleAllExceptions(EnderecoBadRequestException exception) {
        Map<String, Object> map = new HashMap<>();
        map.put("error", exception.getMessage());
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }


}
