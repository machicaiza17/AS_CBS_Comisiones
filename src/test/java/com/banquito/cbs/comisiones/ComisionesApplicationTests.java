package com.banquito.cbs.comisiones;

import com.banquito.cbs.comisiones.modelo.Comision;
import com.banquito.cbs.comisiones.repositorio.ComisionRepository;
import com.banquito.cbs.comisiones.servicio.ComisionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ComisionesApplicationTests {

    @Mock
    private ComisionRepository comisionRepository;

    @InjectMocks
    private ComisionService comisionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCrearComision() {
        Comision comision = new Comision();
        comision.setId(1);
        comision.setIdCuenta(123);
        comision.setFecha(LocalDateTime.now());
        comision.setTotalTransacciones(5);
        comision.setMontoTotal(BigDecimal.valueOf(100));
        comision.setTotalComision(BigDecimal.valueOf(10));
        comision.setDetalleTransacciones("Detalles");
        comision.setEstado("Activo");

        when(comisionRepository.save(comision)).thenReturn(comision);

        Comision nuevaComision = comisionService.crearComision(comision);
        assertNotNull(nuevaComision);
        assertEquals(1, nuevaComision.getId());
    }

    @Test
    void testObtenerComisiones() {
        Comision comision1 = new Comision();
        comision1.setId(1);
        Comision comision2 = new Comision();
        comision2.setId(2);
        List<Comision> comisiones = Arrays.asList(comision1, comision2);

        when(comisionRepository.findAll()).thenReturn(comisiones);

        List<Comision> resultado = comisionService.obtenerComisiones();
        assertEquals(2, resultado.size());
    }

    @Test
    void testObtenerComisionPorId() {
        Comision comision = new Comision();
        comision.setId(1);
        when(comisionRepository.findById(1)).thenReturn(Optional.of(comision));

        Optional<Comision> resultado = comisionService.obtenerComisionPorId(1);
        assertTrue(resultado.isPresent());
        assertEquals(1, resultado.get().getId());
    }

    @Test
    void testActualizarComision() {
        Comision comision = new Comision();
        comision.setId(1);
        when(comisionRepository.save(comision)).thenReturn(comision);

        Comision comisionActualizada = comisionService.actualizarComision(1, comision);
        assertNotNull(comisionActualizada);
        assertEquals(1, comisionActualizada.getId());
    }

    @Test
    void testEliminarComision() {
        doNothing().when(comisionRepository).deleteById(1);
        comisionService.eliminarComision(1);
        verify(comisionRepository, times(1)).deleteById(1);
    }
}
