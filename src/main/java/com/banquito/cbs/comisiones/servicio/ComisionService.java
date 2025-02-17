package com.banquito.cbs.comisiones.servicio;

import com.banquito.cbs.comisiones.repositorio.ComisionRepository;
import org.springframework.stereotype.Service;

@Service
public class ComisionService {
    private final ComisionRepository comisionRepository;

    public ComisionService(ComisionRepository comisionRepository) {
        this.comisionRepository = comisionRepository;
    }
}
