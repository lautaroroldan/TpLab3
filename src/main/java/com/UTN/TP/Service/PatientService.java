package com.UTN.TP.Service;

import com.UTN.TP.Entity.Patient;
import com.UTN.TP.Model.ActionModel;
import com.UTN.TP.Model.PatientModel;

import java.util.List;

public interface PatientService {
    PatientModel addPatient(PatientModel patientModel);
    List<PatientModel> getPatientList();
    PatientModel findById(String id);
    void deletePatient(String id);
    List<PatientModel> findAllByServe(boolean choice);

    List<ActionModel> findTasksById(String id);
    PatientModel findByDni(long dni);

    List<ActionModel> findIncompleteTaskById(String id);

    List<ActionModel> findCompleteTaskById(String id);

    void updateTreatment(String id);
}
