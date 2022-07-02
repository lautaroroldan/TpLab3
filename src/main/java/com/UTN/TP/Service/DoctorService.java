package com.UTN.TP.Service;

import com.UTN.TP.dto.DoctorModel;

<<<<<<< HEAD
=======
import java.util.HashMap;
import java.util.HashSet;
>>>>>>> 96235ac0df5e1f30a334c0082e404e3cf440a052
import java.util.List;

public interface DoctorService {
    //TODO Revisar sobre el HashMap
    DoctorModel addDoctor(DoctorModel doctorModel);
    List<DoctorModel> getDoctorList();
    DoctorModel findById(String id);

    HashMap<String,PatientModel> getAllPatientsFalse(String id);
    HashMap<String,PatientModel> getAllPatientsTrue(String id);
    void deletePatient(String id);
}
