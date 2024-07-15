package com.meli.APIFutebol.services;

import com.meli.APIFutebol.DTO.ClubeDTO;
import com.meli.APIFutebol.DTO.PartidaDTO;
import com.meli.APIFutebol.entities.Clube;
import com.meli.APIFutebol.entities.Estadio;
import com.meli.APIFutebol.entities.Partida;
import com.meli.APIFutebol.repository.PartidaRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartidaService {
    private final PartidaRepository partidaRepository;
    private final ClubeService clubeService;
    private final EstadioService estadioService;

    public PartidaService(PartidaRepository partidaRepository, ClubeService clubeService, EstadioService estadioService) {
        this.partidaRepository = partidaRepository;
        this.clubeService = clubeService;
        this.estadioService = estadioService;
    }

    public PartidaDTO salvar(PartidaDTO partidaDTO) {
        Partida partida = new Partida();
        // preencher partida com dados do DTO
        return new PartidaDTO(partidaRepository.save(partida));
    }

    public PartidaDTO atualizar(PartidaDTO partidaDTO) {
        Partida partida = partidaRepository.findById(partidaDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Partida não encontrada"));
        // preencher partida com dados do DTO
        return new PartidaDTO(partidaRepository.save(partida));
    }

    public void remover(Long id) {
        Partida partida = partidaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Partida não encontrada"));
        partidaRepository.delete(partida);
    }

    public Optional<PartidaDTO> buscarPorId(Long id) {
        return partidaRepository.findById(id).map(PartidaDTO::new);
    }

    public List<PartidaDTO> listar(Long clube, Long estadio, Pageable pageable) {
        List<Partida> partidas = new ArrayList<>();
        if (clube != null) {
            ClubeDTO c = clubeService.buscarPorId(clube).orElseThrow(() -> new ResourceNotFoundException("Clube não encontrado"));
            partidas.addAll(partidaRepository.findByMandanteOrVisitante(c, c));
        } else if (estadio != null) {
            Estadio e = estadioService.buscarPorId(estadio).orElseThrow(() -> new ResourceNotFoundException("Estádio não encontrado"));
            partidas.addAll(partidaRepository.findAll((org.springframework.data.domain.Pageable) pageable).getContent());
        } else {
            partidas.addAll(partidaRepository.findAll((org.springframework.data.domain.Pageable) pageable).getContent());
        }
        return partidas.stream().map(PartidaDTO::new).collect(Collectors.toList());
    }
}
