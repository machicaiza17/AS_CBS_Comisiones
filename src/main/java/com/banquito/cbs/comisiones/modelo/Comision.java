package com.banquito.cbs.comisiones.modelo;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@ToString
public class Comision {
    private Integer id;
    private Integer idCuenta;
    private LocalDateTime fecha;
    private Integer totalTransacciones;
    private BigDecimal montoTotal;
    private BigDecimal totalComision;
    private String detalleTransacciones;
    private String estado;
}
