package com.UTN.TP.mapper;


import com.UTN.TP.entity.Disease;
import com.UTN.TP.dto.DiseaseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DiseaseMapper {
    DiseaseMapper INSTANCE = Mappers.getMapper(DiseaseMapper.class);

    Disease toEntity(DiseaseDTO diseaseDTO);
    DiseaseDTO toModel(Disease disease);
}
