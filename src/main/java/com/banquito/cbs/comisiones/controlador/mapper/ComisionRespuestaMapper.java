package com.banquito.cbs.comisiones.controlador.mapper;

import com.banquito.cbs.comisiones.dto.ComisionRespuestaDto;
import com.banquito.cbs.comisiones.modelo.Comision;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ComisionRespuestaMapper {
    ComisionRespuestaDto toDto(Comision comision);
}
