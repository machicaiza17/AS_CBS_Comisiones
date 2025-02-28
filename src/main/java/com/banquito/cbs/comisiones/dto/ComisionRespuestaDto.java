package com.banquito.cbs.comisiones.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ComisionRespuestaDto {
    private Integer id;
    private Integer idCuenta;
    private LocalDateTime fecha;
    private Integer totalTransacciones;
    private BigDecimal montoTotal;
    private BigDecimal totalComision;
    private String detalleTransacciones;
    private String estado;
}
