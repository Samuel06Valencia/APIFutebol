package com.meli.APIFutebol.controllers;

import com.meli.APIFutebol.DTO.PartidaDTO;
import com.meli.APIFutebol.entities.Partida;
import com.meli.APIFutebol.services.PartidaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/partidas")
public class PartidaController {
    private final PartidaService partidaService;

    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PartidaDTO salvar(@RequestBody  PartidaDTO partidaDTO) {
        return partidaService.salvar(partidaDTO);
    }

    @PutMapping("/{id}")
    public PartidaDTO atualizar(@PathVariable Long id, @RequestBody  PartidaDTO partidaDTO) {
        partidaDTO.setId(id);
        return partidaService.atualizar(partidaDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        partidaService.remover(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidaDTO> buscarPorId(@PathVariable Long id) {
        return partidaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<PartidaDTO> listar(
            @RequestParam(required = false) Long clube,
            @RequestParam(required = false) Long estadio,
            Pageable pageable) {
        return partidaService.listar(clube, estadio, pageable);
    }
}
