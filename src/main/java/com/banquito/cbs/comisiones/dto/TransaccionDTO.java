package com.banquito.cbs.comisiones.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransaccionDTO {
    private BigDecimal monto; // Monto de la transacción
}