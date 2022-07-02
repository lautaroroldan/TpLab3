package com.UTN.TP.Service;

import com.UTN.TP.dto.ActionDTO;
import com.UTN.TP.dto.PatientModel;

import java.util.List;

public interface PatientService {
    PatientModel addPatient(PatientModel patientModel);
    List<PatientModel> getPatientList();
    PatientModel findById(String id);
    PatientModel addIncompleteTask(String id, ActionDTO actionDTO);
}
