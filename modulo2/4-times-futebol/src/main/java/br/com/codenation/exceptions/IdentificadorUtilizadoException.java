package br.com.codenation.exceptions;

public class IdentificadorUtilizadoException extends RuntimeException{
    public IdentificadorUtilizadoException(String errorMessage) {
        super(errorMessage);
    }
}
