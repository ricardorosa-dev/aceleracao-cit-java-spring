package br.com.codenation.exceptions;

public class CapitaoNaoInformadoException extends RuntimeException{
    public CapitaoNaoInformadoException(String errorMessage) {
        super(errorMessage);
    }
}
