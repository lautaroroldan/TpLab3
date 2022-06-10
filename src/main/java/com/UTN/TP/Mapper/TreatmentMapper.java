package com.UTN.TP.Mapper;

import com.UTN.TP.Entity.Treatment;
import com.UTN.TP.Model.TreatmentModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TreatmentMapper {
    TreatmentMapper INSTANCE = Mappers.getMapper(TreatmentMapper.class);

    Treatment toEntity(TreatmentModel treatmentModel);
    TreatmentModel toModel(Treatment treatment);
}
