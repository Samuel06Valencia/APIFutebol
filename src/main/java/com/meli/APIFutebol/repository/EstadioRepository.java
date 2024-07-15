package com.meli.APIFutebol.repository;

import com.meli.APIFutebol.entities.Estadio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadioRepository extends JpaRepository<Estadio, Long> {
    Optional<Estadio> findByNome(String nome);
}
