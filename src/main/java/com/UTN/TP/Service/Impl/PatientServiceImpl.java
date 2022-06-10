package com.UTN.TP.Service.Impl;

import com.UTN.TP.Entity.Patient;
import com.UTN.TP.Mappers.PatientMapper;
import com.UTN.TP.Model.PatientModel;
import com.UTN.TP.Repository.PatientRepository;
import com.UTN.TP.Service.PatientService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("PatientServiceImpl")
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    @Override
    public PatientModel addPatient(PatientModel patientModel) {
        patientRepository.save(INSTANCE.toEntity(patientModel));
        return patientModel;
    }

    @Override
    public List<PatientModel> getPatientList() {
        List<PatientModel> patientModels = new ArrayList<>();
        List<Patient> patients = patientRepository.findAll();
        patients.forEach(x->patientModels.add(INSTANCE.toModel(x)));
        return patientModels;
    }

    //TODO Ojo con esto, ver que devuelve un Patient y no un PatientModel
    public Optional<Patient> findById(String id){

        return patientRepository.findById(id);

    }
}
