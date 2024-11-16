package io.github.GuilhermeHNS.dsList.Exceptions;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException() {
        super("Game não encontrado!");
    }

    public GameNotFoundException(String message) {
        super(message);
    }
}


