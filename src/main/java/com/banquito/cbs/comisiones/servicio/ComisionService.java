package com.banquito.cbs.comisiones.servicio;

import com.banquito.cbs.comisiones.modelo.Comision;
import com.banquito.cbs.comisiones.repositorio.ComisionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComisionService {
    private final ComisionRepository comisionRepository;
    private static final Logger logger = LoggerFactory.getLogger(ComisionService.class);

    public ComisionService(ComisionRepository comisionRepository) {
        this.comisionRepository = comisionRepository;
    }

    public Comision crearComision(Comision comision) {
        logger.info("Creando comision: {}", comision);
        return comisionRepository.save(comision);
    }

    public List<Comision> obtenerComisiones() {
        logger.info("Obteniendo todas las comisiones");
        return comisionRepository.findAll();
    }

    public Optional<Comision> obtenerComisionPorId(Integer id) {
        logger.info("Obteniendo comision con id: {}", id);
        return comisionRepository.findById(id);
    }

    public Comision actualizarComision(Integer id, Comision comision) {
        logger.info("Actualizando comision con id: {}", id);
        comision.setId(id);
        return comisionRepository.save(comision);
    }

    public void eliminarComision(Integer id) {
        logger.info("Eliminando comision con id: {}", id);
        comisionRepository.deleteById(id);
    }
}
