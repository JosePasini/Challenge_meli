package com.example.meli_punto_dos.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Adn implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="adn_string")
    private String adn_string;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "base_datos_prueba")
    private BaseDatosAdn baseDatosAdn;








}
