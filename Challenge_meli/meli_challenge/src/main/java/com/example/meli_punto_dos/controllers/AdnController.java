package com.example.meli_punto_dos.controllers;

import com.example.meli_punto_dos.entities.Adn;
import com.example.meli_punto_dos.entities.AdnCadena;
import com.example.meli_punto_dos.services.AdnServiceImpl;
import org.apache.tomcat.util.buf.Asn1Parser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/")
public class AdnController extends BaseControllerImpl<Adn, AdnServiceImpl> {


    // Traer la lista de ADN desde Service
    @PostMapping("/obtener-adn")
    public AdnCadena adn_cadena_service(@RequestBody AdnCadena lista_adn) {
        return service.mutant(lista_adn);
    }


    // Llamada al método principal
    @PostMapping("/mutant")
    public ResponseEntity<?> adn_cadena_service_isMutant(@RequestBody AdnCadena lista_adn) {
        List<String> lista_copia = service.retorna_lista(lista_adn);
        try{

            if (service.isMutant(lista_copia)){
                return new ResponseEntity<>("Increíblemente es un ~~  ADN  ~~  M U T A N T E  ~~",HttpStatus.OK);
            } else {
                if (service.defectos()) {
                    return new ResponseEntity<>("Lo siento, solo eres un simple humano",HttpStatus.FORBIDDEN);
                } else {
                    return new ResponseEntity<>("Algo salió mal en el ingreso de datos",HttpStatus.FORBIDDEN);
                }

            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"error\":\"Error. No funciona.\"}");
        }
    }


    @GetMapping("/verificar-vacio")
    public ResponseEntity<?> verificar_vacio() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.verificarLista());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Lista vacía.\"}");
        }
    }

    @GetMapping("mostrar-dna")
    public ResponseEntity<?> mostrar_dna() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.mostrarListaAdn());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. por favor ssss itente nuevamente.\"}");
        }
    }



}
