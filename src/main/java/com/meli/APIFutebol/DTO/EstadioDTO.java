package com.meli.APIFutebol.DTO;

import com.meli.APIFutebol.entities.Estadio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadioDTO extends Estadio {
    private Long id;
    private String nome;

    public EstadioDTO(Estadio estadio) {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
