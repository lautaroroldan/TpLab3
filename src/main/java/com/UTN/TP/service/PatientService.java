package com.UTN.TP.service;

import com.UTN.TP.dto.ActionDTO;
import com.UTN.TP.dto.PatientDTO;

import java.util.List;

public interface PatientService {
    PatientDTO addPatient(PatientDTO patientDTO);
    List<PatientDTO> getPatientList();
    PatientDTO findById(String id);

    void deletePatient(String id);
    List<PatientDTO> findAllByServe(boolean choice);

    List<ActionDTO> findTasksById(String id);
    PatientDTO findByDni(long dni);

    List<ActionDTO> findIncompleteTaskById(String id);

    List<ActionDTO> findCompleteTaskById(String id);

}
