package com.example.meli_punto_dos.controllers;

import com.example.meli_punto_dos.entities.BaseDatosAdn;
import com.example.meli_punto_dos.response.ReturnResponse;
import com.example.meli_punto_dos.services.BaseDatosAdnServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/bd")
public class BaseDatosAdnController extends BaseControllerImpl<BaseDatosAdn, BaseDatosAdnServiceImpl> {

    @GetMapping("/stats")
    public ResponseEntity<?> ultimo_json() throws Exception {
        try{
            Double humanos = Double.parseDouble(String.valueOf(this.service.cantidad_humanos()));
            Double mutantes = Double.parseDouble(String.valueOf(this.service.cantidad_mutantes()));
            Double ratio_double = mutantes / humanos;
            return ReturnResponse.generateResponse(mutantes,humanos, ratio_double, HttpStatus.OK);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
