package com.meli.APIFutebol.repository;

import com.meli.APIFutebol.DTO.ClubeDTO;
import com.meli.APIFutebol.entities.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartidaRepository extends JpaRepository<Partida, Long> {
    List<Partida> findByMandanteOrVisitante(ClubeDTO clube1, ClubeDTO clube2);
}
