package com.UTN.TP.service;

import com.UTN.TP.dto.DoctorDTO;
import com.UTN.TP.dto.PatientDTO;


import java.util.HashMap;
import java.util.List;

public interface DoctorService {
    //TODO Revisar sobre el HashMap
    DoctorDTO addDoctor(DoctorDTO doctorDTO);
    List<DoctorDTO> getDoctorList();
    DoctorDTO findById(String id);

    HashMap<String, PatientDTO> getAllPatientsFalse(String id);
    HashMap<String,PatientDTO> getAllPatientsTrue(String id);
    void deletePatient(String id);
}
