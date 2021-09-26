package com.example.meli_punto_dos.controllers;

import com.example.meli_punto_dos.entities.BaseDatosAdn;
import com.example.meli_punto_dos.services.BaseDatosAdnServiceImpl;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/baseDatosAdn")
public class BaseDatosAdnController extends BaseControllerImpl<BaseDatosAdn, BaseDatosAdnServiceImpl> {

    // ULTIMO MÉTODO HAY QUE MEJORARLO TODAVÍA.
    // TIENE QUE RETORNAR JSON Y RETORNA STRING
    @GetMapping("/final")
    String ultimo() throws Exception {
        try{
            Integer humanos = this.service.cantidad_humanos();
            Integer mutantes = this.service.cantidad_mutantes();
            Double ratio = Double.parseDouble(String.valueOf(mutantes))/ Double.parseDouble(String.valueOf(humanos));
            return "Mutantes : " + mutantes + "\nHumanos: " + humanos + "\nRatio: " + ratio;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
