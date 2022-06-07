package com.UTN.TP.Mappers;


import com.UTN.TP.Entity.Disease;
import com.UTN.TP.Model.DiseaseModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DiseaseMapper {
    DiseaseMapper INSTANCE = Mappers.getMapper(DiseaseMapper.class);

    Disease toEntity(DiseaseModel diseaseModel);
    DiseaseModel toModel(Disease disease);
}
