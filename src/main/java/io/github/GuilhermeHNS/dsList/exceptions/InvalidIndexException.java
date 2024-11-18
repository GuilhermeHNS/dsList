package io.github.GuilhermeHNS.dsList.exceptions;

public class InvalidIndexException extends RuntimeException {
    public InvalidIndexException() {
        super("Posição inválida!");
    }

    public InvalidIndexException(String messsage) {
        super(messsage);
    }
}
