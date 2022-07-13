package com.UTN.TP.mapper;

import com.UTN.TP.entity.Patient;
import com.UTN.TP.dto.PatientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    Patient toEntity(PatientDTO patientDTO);
    PatientDTO toModel(Patient patient);

}
