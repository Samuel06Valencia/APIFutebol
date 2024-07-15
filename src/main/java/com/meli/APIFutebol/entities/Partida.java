package com.meli.APIFutebol.entities;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

@Entity
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    private Clube mandante;

    @ManyToOne
    @NotNull
    private Clube visitante;

    @NotNull
    private int golsMandante;

    @NotNull
    private int golsVisitante;

    @ManyToOne
    @NotNull
    private Estadio estadio;

    @NotNull
    private LocalDateTime dataHora;

    // getters, setters, construtores
}
