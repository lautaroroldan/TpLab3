package com.UTN.TP.Service.Impl;

import com.UTN.TP.Entity.Doctor;
import com.UTN.TP.Mapper.DoctorMapper;
import com.UTN.TP.Mapper.PatientMapper;
import com.UTN.TP.Model.DoctorModel;
import com.UTN.TP.Model.PatientModel;
import com.UTN.TP.Repository.DoctorRepository;
import com.UTN.TP.Service.DoctorService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service("DoctorServiceImpl")
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    PatientMapper INSTANCEPATIENT = Mappers.getMapper(PatientMapper.class);

    private static final Log LOG = LogFactory.getLog(DoctorServiceImpl.class);

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

    @Override
    public DoctorModel findById(String id) {
        Optional<Doctor> opt = doctorRepository.findById(id);
        if (opt.isPresent()){
            return INSTANCE.toModel(opt.get());
        }
        return new DoctorModel();
    }

    @Override
    public HashMap<String,PatientModel> getAllPatientsFalse(String id) {
        Optional<Doctor> opt = doctorRepository.findById(id);
        LOG.info("METHOD : getAllPatientsFalse");
        DoctorModel doc = new DoctorModel();
        if (opt.isPresent()){
            doc = INSTANCE.toModel(opt.get());
        }
        HashMap<String,PatientModel> hashMapFalse = new HashMap<>();
        doc.getPatients().forEach( (k,v)-> {
            if (!v.isServe()){
                hashMapFalse.put(k,v);
            }
        });
        LOG.info("RETURN FALSE HASHMAP " + hashMapFalse);
        return hashMapFalse;
    }

    @Override
    public HashMap<String,PatientModel> getAllPatientsTrue(String id) {
        Optional<Doctor> opt = doctorRepository.findById(id);
        LOG.info("METHOD : getAllPatientsTrue");
        DoctorModel doc = new DoctorModel();
        if (opt.isPresent()){
            doc = INSTANCE.toModel(opt.get());
        }
        HashMap<String,PatientModel> hashMaptrue = new HashMap<>();
        doc.getPatients().forEach( (k,v)-> {
            if (v.isServe()){
                hashMaptrue.put(k,v);
            }
        });
        LOG.info("RETURN TRUE HASHMAP " + hashMaptrue);
        return hashMaptrue;
    }

    @Override
    public void deletePatient(String idPatient) {
        List<Doctor> doctorList = doctorRepository.findAll();
        doctorList.forEach(x -> {
            LOG.info("Method : deletePatient -- Searching patient");
            x.getPatients().remove(idPatient);
            doctorRepository.save(x);
        });
    }

}
