package com.meli.APIFutebol.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.antlr.v4.runtime.misc.NotNull;


import java.time.LocalDate;

@Entity
public class Clube {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    //@Size(min = 2)
    private String nome;


    private String estado;

    @NotNull
    private LocalDate dataCriacao;

    private boolean ativo;

    // getters, setters, construtores

    //construtores:

    public Clube() {
    }

    public Clube(Long id, String nome, String estado, LocalDate dataCriacao, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.dataCriacao = dataCriacao;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}

