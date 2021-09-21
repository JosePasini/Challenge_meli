package com.example.meli_punto_dos.controllers;

import com.example.meli_punto_dos.entities.Adn;
import com.example.meli_punto_dos.services.AdnServiceImpl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/mutant")
public class AdnController extends BaseControllerImpl<Adn, AdnServiceImpl>{




}
