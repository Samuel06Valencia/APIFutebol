package com.meli.APIFutebol.DTO;

import com.meli.APIFutebol.entities.Partida;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidaDTO {
    private Long id;
    private ClubeDTO mandante;
    private ClubeDTO visitante;
    private int golsMandante;
    private int golsVisitante;
    private EstadioDTO estadio;
    private LocalDateTime dataHora;


    public PartidaDTO(Partida partida) {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClubeDTO getMandante() {
        return mandante;
    }

    public void setMandante(ClubeDTO mandante) {
        this.mandante = mandante;
    }

    public ClubeDTO getVisitante() {
        return visitante;
    }

    public void setVisitante(ClubeDTO visitante) {
        this.visitante = visitante;
    }

    public int getGolsMandante() {
        return golsMandante;
    }

    public void setGolsMandante(int golsMandante) {
        this.golsMandante = golsMandante;
    }

    public int getGolsVisitante() {
        return golsVisitante;
    }

    public void setGolsVisitante(int golsVisitante) {
        this.golsVisitante = golsVisitante;
    }

    public EstadioDTO getEstadio() {
        return estadio;
    }

    public void setEstadio(EstadioDTO estadio) {
        this.estadio = estadio;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}