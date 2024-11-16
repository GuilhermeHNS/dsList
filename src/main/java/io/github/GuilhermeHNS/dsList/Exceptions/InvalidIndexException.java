package io.github.GuilhermeHNS.dsList.Exceptions;

public class InvalidIndexException extends RuntimeException {
    public InvalidIndexException() {
        super("Posição inválida!");
    }

    public InvalidIndexException(String messsage) {
        super(messsage);
    }
}
