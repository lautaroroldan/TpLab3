package com.UTN.TP.Mapper;

import com.UTN.TP.Entity.Patient;
import com.UTN.TP.Model.PatientModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    Patient toEntity(PatientModel patientModel);
    PatientModel toModel(Patient patient);

}
