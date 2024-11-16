package io.github.GuilhermeHNS.dsList.configurations;

import io.github.GuilhermeHNS.dsList.Exceptions.GameNotFoundException;
import io.github.GuilhermeHNS.dsList.Exceptions.InvalidIndexException;
import io.github.GuilhermeHNS.dsList.Exceptions.RestErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.HashMap;
import java.util.Map;
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GameNotFoundException.class)
    private ResponseEntity<RestErrorMessage> gameNotFoundHandler(GameNotFoundException e) {
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.NOT_FOUND, "Game não encontrado!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restErrorMessage);
    }

    @ExceptionHandler(InvalidIndexException.class)
    private ResponseEntity<RestErrorMessage> invalidIndexHandler(InvalidIndexException e) {
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.BAD_REQUEST, "Posição inexistente!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(restErrorMessage);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String messageError = ex.getBindingResult().getFieldError().getDefaultMessage();
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.BAD_REQUEST, messageError);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(restErrorMessage);
    }
}
