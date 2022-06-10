package com.UTN.TP.Mapper;

import com.UTN.TP.Entity.Doctor;
import com.UTN.TP.Model.DoctorModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    Doctor toEntity(DoctorModel doctorModel);
    DoctorModel toModel(Doctor doctor);
}
