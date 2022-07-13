package com.UTN.TP.service;

<<<<<<< HEAD
import com.UTN.TP.dto.ActionDTO;
import com.UTN.TP.dto.PatientDTO;
=======
import com.UTN.TP.Model.ActionModel;
import com.UTN.TP.Model.PatientModel;
>>>>>>> 96235ac0df5e1f30a334c0082e404e3cf440a052

import java.util.List;

public interface PatientService {
    PatientDTO addPatient(PatientDTO patientDTO);
    List<PatientDTO> getPatientList();
    PatientDTO findById(String id);
<<<<<<< HEAD
    PatientDTO addIncompleteTask(String id, ActionDTO actionDTO);
=======
    void deletePatient(String id);
    List<PatientDTO> findAllByServe(boolean choice);

    List<ActionModel> findTasksById(String id);
    PatientDTO findByDni(long dni);

    List<ActionModel> findIncompleteTaskById(String id);

    List<ActionModel> findCompleteTaskById(String id);
>>>>>>> 96235ac0df5e1f30a334c0082e404e3cf440a052
}
