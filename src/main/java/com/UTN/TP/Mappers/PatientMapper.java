package com.UTN.TP.Mappers;

import com.UTN.TP.Entity.Disease;
import com.UTN.TP.Entity.Patient;
import com.UTN.TP.Model.DiseaseModel;
import com.UTN.TP.Model.PatientModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface PatientMapper {

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    Patient toEntity(PatientModel patientModel);
    PatientModel toModel(Patient patient);

}
