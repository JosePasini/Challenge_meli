package com.example.meli_punto_dos.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class AdnCadena implements Serializable {

    @JsonProperty("dna")
    private List<String> adn_cadena;



}
