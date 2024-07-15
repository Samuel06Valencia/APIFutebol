package com.meli.APIFutebol.services;

import com.meli.APIFutebol.DTO.EstadioDTO;
import com.meli.APIFutebol.entities.Estadio;
import com.meli.APIFutebol.repository.EstadioRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstadioService {
    private final EstadioRepository estadioRepository;

    public EstadioService(EstadioRepository estadioRepository) {
        this.estadioRepository = estadioRepository;
    }

    public EstadioDTO salvar(EstadioDTO estadioDTO) {
        Estadio estadio = new Estadio();
        // preencher estadio com dados do DTO
        return new EstadioDTO(estadioRepository.save(estadio));
    }

    public EstadioDTO atualizar(EstadioDTO estadioDTO) {
        Estadio estadio = estadioRepository.findById(estadioDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Estádio não encontrado"));
        // preencher estadio com dados do DTO
        return new EstadioDTO(estadioRepository.save(estadio));
    }

    public Optional<EstadioDTO> buscarPorId(Long id) {
        return estadioRepository.findById(id).map(EstadioDTO::new);
    }

    public List<EstadioDTO> listar(Pageable pageable) {
        return estadioRepository.findAll((org.springframework.data.domain.Pageable) pageable).stream()
                .map(EstadioDTO::new)
                .collect(Collectors.toList());
    }
}
