package com.UTN.TP.service.imp;

import com.UTN.TP.dto.PatientDTO;
import com.UTN.TP.entity.Doctor;
import com.UTN.TP.mapper.DoctorMapper;
import com.UTN.TP.dto.DoctorDTO;
import com.UTN.TP.mapper.PatientMapper;
import com.UTN.TP.repository.DoctorRepository;
import com.UTN.TP.service.DoctorService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("DoctorServiceImpl")
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    PatientMapper INSTANCEPATIENT = Mappers.getMapper(PatientMapper.class);

    private static final Log LOG = LogFactory.getLog(DoctorServiceImpl.class);

    @Override
    public DoctorDTO addDoctor(DoctorDTO doctorDTO) {
        doctorRepository.save(INSTANCE.toEntity(doctorDTO));
        return doctorDTO;
    }

    @Override
    public List<DoctorDTO> getDoctorList() {
        List<DoctorDTO> doctorDTOS = new ArrayList<>();
        List<Doctor> doctorList = doctorRepository.findAll();
        doctorList.forEach(x -> doctorDTOS.add(INSTANCE.toModel(x)));
        return doctorDTOS;
    }

    @Override
    public DoctorDTO findById(String id) {
        Optional<Doctor> opt = doctorRepository.findById(id);
        if (opt.isPresent()){
            return INSTANCE.toModel(opt.get());
        }
        return new DoctorDTO();
    }

    @Override
    public HashMap<String, PatientDTO> getAllPatientsFalse(String id) {
        Optional<Doctor> opt = doctorRepository.findById(id);
        LOG.info("METHOD : getAllPatientsFalse");
        DoctorDTO doc = new DoctorDTO();
        if (opt.isPresent()){
            doc = INSTANCE.toModel(opt.get());
        }
        HashMap<String,PatientDTO> hashMapFalse = new HashMap<>();
        doc.getPatients().forEach( (k,v)-> {
            if (!v.isServe()){
                hashMapFalse.put(k,v);
            }
        });
        LOG.info("RETURN FALSE HASHMAP " + hashMapFalse);
        return hashMapFalse;
    }

    @Override
    public HashMap<String,PatientDTO> getAllPatientsTrue(String id) {
        Optional<Doctor> opt = doctorRepository.findById(id);
        LOG.info("METHOD : getAllPatientsTrue");
        DoctorDTO doc = new DoctorDTO();
        if (opt.isPresent()){
            doc = INSTANCE.toModel(opt.get());
        }
        HashMap<String,PatientDTO> hashMaptrue = new HashMap<>();
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
