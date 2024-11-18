package io.github.GuilhermeHNS.dsList.exceptions;

public class ListGameNotFoundException extends RuntimeException {
    public ListGameNotFoundException() {
        super("Lista de Jogos não encontrada!");
    }

    public ListGameNotFoundException(String message) {
        super(message);
    }
}
