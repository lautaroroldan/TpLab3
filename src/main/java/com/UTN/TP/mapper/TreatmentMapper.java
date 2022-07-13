package com.UTN.TP.mapper;

import com.UTN.TP.entity.Treatment;
import com.UTN.TP.dto.TreatmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TreatmentMapper {
    TreatmentMapper INSTANCE = Mappers.getMapper(TreatmentMapper.class);

    Treatment toEntity(TreatmentDTO treatmentDTO);
    TreatmentDTO toModel(Treatment treatment);
}
