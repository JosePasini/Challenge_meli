package com.example.meli_punto_dos.controllers;

import com.example.meli_punto_dos.entities.BaseDatosAdn;
import com.example.meli_punto_dos.services.BaseDatosAdnServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/baseDatosAdn")
public class BaseDatosAdnController extends BaseControllerImpl<BaseDatosAdn, BaseDatosAdnServiceImpl> {



}
