package com.banquito.cbs.comisiones.modelo;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@ToString
@Document(collection = "COMISIONES")
public class Comision {
    @MongoId
    private Integer id;
    private Integer idCuenta;
    private LocalDateTime fecha;
    private Integer totalTransacciones;
    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal montoTotal;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal totalComision;
    private String detalleTransacciones;
    private String estado;
}
