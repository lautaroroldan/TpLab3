package com.UTN.TP.Service.Impl;

import com.UTN.TP.Entity.Doctor;
import com.UTN.TP.Mapper.DoctorMapper;
import com.UTN.TP.Model.DoctorModel;
import com.UTN.TP.Repository.DoctorRepository;
import com.UTN.TP.Service.DoctorService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("DoctorServiceImpl")
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    @Override
    public DoctorModel addDoctor(DoctorModel doctorModel) {
        doctorRepository.save(INSTANCE.toEntity(doctorModel));
        return doctorModel;
    }

    @Override
    public List<DoctorModel> getDoctorList() {
        List<DoctorModel> doctorModels = new ArrayList<>();
        List<Doctor> doctorList = doctorRepository.findAll();
        doctorList.forEach(x -> doctorModels.add(INSTANCE.toModel(x)));
        return doctorModels;
    }
}
