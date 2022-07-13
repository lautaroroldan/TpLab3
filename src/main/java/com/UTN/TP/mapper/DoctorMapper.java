package com.UTN.TP.mapper;

import com.UTN.TP.entity.Doctor;
import com.UTN.TP.dto.DoctorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    Doctor toEntity(DoctorDTO doctorDTO);
    DoctorDTO toModel(Doctor doctor);
}
