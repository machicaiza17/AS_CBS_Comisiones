package com.banquito.cbs.comisiones.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class InicioController {
    @GetMapping
    public ResponseEntity<String> inicio() {
        return ResponseEntity.ok("Servicio de comisiones");
    }
}
