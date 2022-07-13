package com.UTN.TP.service;

import com.UTN.TP.dto.DoctorDTO;

<<<<<<< HEAD
=======
import java.util.HashMap;
>>>>>>> 96235ac0df5e1f30a334c0082e404e3cf440a052
import java.util.List;

public interface DoctorService {
    //TODO Revisar sobre el HashMap
    DoctorDTO addDoctor(DoctorDTO doctorDTO);
    List<DoctorDTO> getDoctorList();
    DoctorDTO findById(String id);

    HashMap<String,PatientModel> getAllPatientsFalse(String id);
    HashMap<String,PatientModel> getAllPatientsTrue(String id);
    void deletePatient(String id);
}
