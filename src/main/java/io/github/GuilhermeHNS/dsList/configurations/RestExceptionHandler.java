package io.github.GuilhermeHNS.dsList.configurations;

import io.github.GuilhermeHNS.dsList.exceptions.GameNotFoundException;
import io.github.GuilhermeHNS.dsList.exceptions.InvalidIndexException;
import io.github.GuilhermeHNS.dsList.exceptions.ListGameNotFoundException;
import io.github.GuilhermeHNS.dsList.exceptions.RestErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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

    @ExceptionHandler(ListGameNotFoundException.class)
    private ResponseEntity<RestErrorMessage> listGameNotFoundHandler(ListGameNotFoundException e) {
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.NOT_FOUND, "Lista não encontrada!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restErrorMessage);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String messageError = ex.getBindingResult().getFieldError().getDefaultMessage();
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.BAD_REQUEST, messageError);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(restErrorMessage);
    }
}
