package com.meli.APIFutebol.controllers;

import com.meli.APIFutebol.DTO.ClubeDTO;
import com.meli.APIFutebol.entities.Clube;
import com.meli.APIFutebol.services.ClubeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/clubes")
public class ClubeController {
    private final ClubeService clubeService;

    public ClubeController(ClubeService clubeService) {
        this.clubeService = clubeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClubeDTO salvar(@RequestBody  ClubeDTO clubeDTO) {
        return clubeService.salvar(clubeDTO);
    }

    @PutMapping("/{id}")
    public ClubeDTO atualizar(@PathVariable Long id, @RequestBody ClubeDTO clubeDTO) {
        clubeDTO.setId(id);
        return clubeService.atualizar(clubeDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void inativar(@PathVariable Long id) {
        clubeService.inativar(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClubeDTO> buscarPorId(@PathVariable Long id) {
        return clubeService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<ClubeDTO> listar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String estado,
            @RequestParam(required = false, defaultValue = "true") boolean ativo,
            Pageable pageable) {
        return clubeService.listar(nome, estado, ativo, (org.springframework.data.domain.Pageable) pageable);
    }
}
