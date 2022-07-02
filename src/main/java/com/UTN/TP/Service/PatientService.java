package com.UTN.TP.Service;

<<<<<<< HEAD
import com.UTN.TP.dto.ActionDTO;
import com.UTN.TP.dto.PatientModel;
=======
import com.UTN.TP.Entity.Patient;
import com.UTN.TP.Model.ActionModel;
import com.UTN.TP.Model.PatientModel;
>>>>>>> 96235ac0df5e1f30a334c0082e404e3cf440a052

import java.util.List;

public interface PatientService {
    PatientModel addPatient(PatientModel patientModel);
    List<PatientModel> getPatientList();
    PatientModel findById(String id);
<<<<<<< HEAD
    PatientModel addIncompleteTask(String id, ActionDTO actionDTO);
=======
    void deletePatient(String id);
    List<PatientModel> findAllByServe(boolean choice);

    List<ActionModel> findTasksById(String id);
    PatientModel findByDni(long dni);

    List<ActionModel> findIncompleteTaskById(String id);

    List<ActionModel> findCompleteTaskById(String id);
>>>>>>> 96235ac0df5e1f30a334c0082e404e3cf440a052
}
