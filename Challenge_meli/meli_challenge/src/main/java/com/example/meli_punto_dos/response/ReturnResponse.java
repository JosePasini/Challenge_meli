package com.example.meli_punto_dos.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ReturnResponse {
    public static ResponseEntity<Object> generateResponse(Double contador_mutante, Double contador_humanos, Double ratio, HttpStatus status){
        Map<String, Object> map = new HashMap<>();
        map.put("Contador mutantes", contador_mutante);
        map.put("Contador humanos", contador_humanos);
        map.put("ratio", ratio);
        map.put("status", status.value());
        return new ResponseEntity<Object>(map, status);
    }

}
