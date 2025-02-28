package com.banquito.cbs.comisiones.servicio;

import com.banquito.cbs.comisiones.dto.TransaccionDTO;
import com.banquito.cbs.comisiones.modelo.CobroComision;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CobroComisionService {
    private static final Logger logger = LoggerFactory.getLogger(CobroComisionService.class);

    public void procesarCobro(CobroComision cobroComision) {
        logger.info("Procesando cobro de comision: {}", cobroComision);

        BigDecimal totalTransacciones = BigDecimal.ZERO;
        for (TransaccionDTO transaccion : cobroComision.getTransacciones()) {
            totalTransacciones = totalTransacciones.add(transaccion.getMonto());
        }

        BigDecimal comision = totalTransacciones.multiply(cobroComision.getPorcentajeComision()).divide(BigDecimal.valueOf(100));
        
        logger.info("Total de transacciones: {}", totalTransacciones);
        logger.info("Comisión calculada: {}", comision);
    }
}