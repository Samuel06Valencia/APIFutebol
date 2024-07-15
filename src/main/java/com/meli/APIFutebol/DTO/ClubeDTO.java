package com.meli.APIFutebol.DTO;

import com.meli.APIFutebol.entities.Clube;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubeDTO {
    private Long id;
    private String nome;
    private String estado;
    private LocalDate dataCriacao;
    private boolean ativo;

    public ClubeDTO(Clube clube) {
    }

    public ClubeDTO(Long id, String nome, String estado, LocalDate dataCriacao, boolean ativo) {
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
