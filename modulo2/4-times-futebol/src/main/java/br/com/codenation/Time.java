package br.com.codenation;

import java.time.LocalDate;

public class Time{
    Long id;
    String nome;
    LocalDate dataCriacao;
    String corUniformePrincipal;
    String corUniformeSecundario;

    public Long getId() {
        return id;
    }

    public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.corUniformePrincipal = corUniformePrincipal;
        this.corUniformeSecundario = corUniformeSecundario;
    }
}
