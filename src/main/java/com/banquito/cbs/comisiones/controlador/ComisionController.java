package com.banquito.cbs.comisiones.controlador;

import com.banquito.cbs.comisiones.modelo.Comision;
import com.banquito.cbs.comisiones.modelo.CobroComision;
import com.banquito.cbs.comisiones.servicio.ComisionService;
import com.banquito.cbs.comisiones.servicio.CobroComisionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/comisiones")
public class ComisionController {
    private final ComisionService comisionService;
    private final CobroComisionService cobroComisionService;
    private static final Logger logger = LoggerFactory.getLogger(ComisionController.class);

    public ComisionController(ComisionService comisionService, CobroComisionService cobroComisionService) {
        this.comisionService = comisionService;
        this.cobroComisionService = cobroComisionService;
    }

    @Operation(summary = "Crear una nueva comisión")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Comisión creada exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping
    public ResponseEntity<Comision> crearComision(@RequestBody Comision comision) {
        logger.info("Solicitud para crear comision: {}", comision);
        Comision nuevaComision = comisionService.crearComision(comision);
        return ResponseEntity.ok(nuevaComision);
    }

    @Operation(summary = "Obtener todas las comisiones")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Comisiones obtenidas exitosamente"),
        @ApiResponse(responseCode = "404", description = "No se encontraron comisiones")
    })
    @GetMapping
    public ResponseEntity<List<Comision>> obtenerComisiones() {
        logger.info("Solicitud para obtener todas las comisiones");
        List<Comision> comisiones = comisionService.obtenerComisiones();
        return ResponseEntity.ok(comisiones);
    }

    @Operation(summary = "Obtener una comisión por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Comisión encontrada"),
        @ApiResponse(responseCode = "404", description = "Comisión no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Comision> obtenerComisionPorId(@PathVariable Integer id) {
        logger.info("Solicitud para obtener comision con id: {}", id);
        return comisionService.obtenerComisionPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Actualizar una comisión existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Comisión actualizada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Comisión no encontrada")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Comision> actualizarComision(@PathVariable Integer id, @RequestBody Comision comision) {
        logger.info("Solicitud para actualizar comision con id: {}", id);
        Comision comisionActualizada = comisionService.actualizarComision(id, comision);
        return ResponseEntity.ok(comisionActualizada);
    }

    @Operation(summary = "Eliminar una comisión por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Comisión eliminada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Comisión no encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComision(@PathVariable Integer id) {
        logger.info("Solicitud para eliminar comision con id: {}", id);
        comisionService.eliminarComision(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Realizar el cobro de comisiones")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cobro realizado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida")
    })
    @PostMapping("/cobro")
    public ResponseEntity<Void> realizarCobro(@RequestBody CobroComision cobroComision) {
        logger.info("Solicitud para realizar cobro de comision: {}", cobroComision);
        cobroComisionService.procesarCobro(cobroComision);
        return ResponseEntity.ok().build();
    }
}
