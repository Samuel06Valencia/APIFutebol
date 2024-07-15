package com.meli.APIFutebol.services;

import com.meli.APIFutebol.DTO.ClubeDTO;
import com.meli.APIFutebol.entities.Clube;
import com.meli.APIFutebol.repository.ClubeRepository;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClubeService {
    private final ClubeRepository clubeRepository;

    public ClubeService(ClubeRepository clubeRepository) {
        this.clubeRepository = clubeRepository;
    }

    public ClubeDTO salvar(ClubeDTO clubeDTO) {
        Clube clube = new Clube();
        // preencher clube com dados do DTO
        return new ClubeDTO(clubeRepository.save(clube));
    }

    public ClubeDTO atualizar(ClubeDTO clubeDTO) {
        Clube clube = new Clube();
        // preencher clube com dados do DTO
        return new ClubeDTO(clubeRepository.save(clube));
    }

    public void inativar(Long id) {
        Clube clube = clubeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Clube não encontrado"));
        clube.setAtivo(false);
        clubeRepository.save(clube);
    }

    public Optional<ClubeDTO> buscarPorId(Long id) {
        return clubeRepository.findById(id).map(ClubeDTO::new);
    }

    public List<ClubeDTO> listar(String nome, String estado, boolean ativo, Pageable pageable) {
        return clubeRepository.findAll(pageable).stream()
                .filter(c -> StringUtils.containsIgnoreCase(c.getNome(), nome)
                        && StringUtils.containsIgnoreCase(c.getEstado(), estado)
                        && c.isAtivo() == ativo)
                .map(ClubeDTO::new)
                .collect(Collectors.toList());
    }


}
