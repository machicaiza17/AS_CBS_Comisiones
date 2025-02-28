package com.banquito.cbs.comisiones.modelo;

import com.banquito.cbs.comisiones.dto.TransaccionDTO;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CobroComision {
    private Integer idCuenta;
    private BigDecimal porcentajeComision; // Porcentaje de comisión a cobrar
    private TransaccionDTO[] transacciones; // Arreglo de transacciones
}