package com.banquito.cbs.comisiones.controlador;

import com.banquito.cbs.comisiones.servicio.ComisionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/comisiones")
public class ComisionController {
    private final ComisionService comisionService;

    public ComisionController(ComisionService comisionService) {
        this.comisionService = comisionService;
    }
}
