package com.meli.APIFutebol.repository;

import com.meli.APIFutebol.entities.Clube;
import com.meli.APIFutebol.entities.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClubeRepository extends JpaRepository<Clube, Long> {
    Optional<Clube> findByNomeAndEstado(String nome, String estado);
}

