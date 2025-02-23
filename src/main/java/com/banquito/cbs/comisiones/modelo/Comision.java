package com.banquito.cbs.comisiones.modelo;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "COMISIONES")
public class Comision {
    @Id
    private Integer id;
    private Integer idCuenta;
    private LocalDateTime fecha;
    private Integer totalTransacciones;
    private BigDecimal montoTotal;
    private BigDecimal totalComision;
    private String detalleTransacciones;
    private String estado;
}
