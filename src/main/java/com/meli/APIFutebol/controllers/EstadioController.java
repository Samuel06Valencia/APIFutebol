package com.meli.APIFutebol.controllers;

import com.meli.APIFutebol.DTO.EstadioDTO;
import com.meli.APIFutebol.services.EstadioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/estadios")
public class EstadioController {
    private final EstadioService estadioService;

    public EstadioController(EstadioService estadioService) {
        this.estadioService = estadioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EstadioDTO salvar(@RequestBody  EstadioDTO estadioDTO) {
        return estadioService.salvar(estadioDTO);
    }

    @PutMapping("/{id}")
    public EstadioDTO atualizar(@PathVariable Long id, @RequestBody  EstadioDTO estadioDTO) {
        estadioDTO.setId(id);
        return estadioService.atualizar(estadioDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadioDTO> buscarPorId(@PathVariable Long id) {
        return estadioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<EstadioDTO> listar(Pageable pageable) {
        return estadioService.listar(pageable);
    }
}
