package com.example.meli_punto_dos.services;

import com.example.meli_punto_dos.entities.Adn;
import com.example.meli_punto_dos.entities.AdnCadena;

import java.util.List;

public interface AdnService extends BaseService<Adn, Long>{

    public AdnCadena mutant(AdnCadena lista);
}
