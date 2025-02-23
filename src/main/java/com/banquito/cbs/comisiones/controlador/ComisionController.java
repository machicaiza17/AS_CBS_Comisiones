package com.banquito.cbs.comisiones.controlador;

import com.banquito.cbs.comisiones.modelo.Comision;
import com.banquito.cbs.comisiones.servicio.ComisionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/comisiones")
public class ComisionController {
    private final ComisionService comisionService;
    private static final Logger logger = LoggerFactory.getLogger(ComisionController.class);

    public ComisionController(ComisionService comisionService) {
        this.comisionService = comisionService;
    }

    @PostMapping
    public ResponseEntity<Comision> crearComision(@RequestBody Comision comision) {
        logger.info("Solicitud para crear comision: {}", comision);
        Comision nuevaComision = comisionService.crearComision(comision);
        return ResponseEntity.ok(nuevaComision);
    }

    @GetMapping
    public ResponseEntity<List<Comision>> obtenerComisiones() {
        logger.info("Solicitud para obtener todas las comisiones");
        List<Comision> comisiones = comisionService.obtenerComisiones();
        return ResponseEntity.ok(comisiones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comision> obtenerComisionPorId(@PathVariable Integer id) {
        logger.info("Solicitud para obtener comision con id: {}", id);
        return comisionService.obtenerComisionPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comision> actualizarComision(@PathVariable Integer id, @RequestBody Comision comision) {
        logger.info("Solicitud para actualizar comision con id: {}", id);
        Comision comisionActualizada = comisionService.actualizarComision(id, comision);
        return ResponseEntity.ok(comisionActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComision(@PathVariable Integer id) {
        logger.info("Solicitud para eliminar comision con id: {}", id);
        comisionService.eliminarComision(id);
        return ResponseEntity.noContent().build();
    }
}
