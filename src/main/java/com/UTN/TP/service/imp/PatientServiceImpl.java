package com.UTN.TP.service.imp;

import com.UTN.TP.entity.Patient;
import com.UTN.TP.mapper.PatientMapper;
<<<<<<< HEAD
import com.UTN.TP.dto.ActionDTO;
import com.UTN.TP.dto.PatientDTO;
=======
import com.UTN.TP.Model.ActionModel;
import com.UTN.TP.Model.PatientModel;
>>>>>>> 96235ac0df5e1f30a334c0082e404e3cf440a052
import com.UTN.TP.repository.PatientRepository;
import com.UTN.TP.service.DoctorService;
import com.UTN.TP.service.PatientService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("PatientServiceImpl")
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorService doctorService;

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    private static final Log LOG = LogFactory.getLog(PatientServiceImpl.class);

    @Override
    public PatientDTO addPatient(PatientDTO patientDTO) {
        patientRepository.save(INSTANCE.toEntity(patientDTO));
        return patientDTO;
    }

    @Override
    public List<PatientDTO> getPatientList() {
        List<PatientDTO> patientDTOS = new ArrayList<>();
        List<Patient> patients = patientRepository.findAll();
        patients.forEach(x-> patientDTOS.add(INSTANCE.toModel(x)));
        return patientDTOS;
    }

    public PatientDTO findById(String id){
        Optional<Patient> opt = patientRepository.findById(id);
        return INSTANCE.toModel(opt.get());

    }

    @Override
<<<<<<< HEAD
    public PatientDTO addIncompleteTask(String id, ActionDTO actionDTO) {

        return null;
=======
    public void deletePatient(String id) {
        doctorService.deletePatient(id);
        patientRepository.deleteById(id);
>>>>>>> 96235ac0df5e1f30a334c0082e404e3cf440a052
    }

    @Override
    public List<PatientDTO> findAllByServe(boolean choice) {
        List<PatientDTO> patientDTOS = new ArrayList<>();
        patientRepository.findAllByServe(false).forEach(x-> patientDTOS.add(INSTANCE.toModel(x)));
        return patientDTOS;
    }

    @Override
    public List<ActionModel> findTasksById(String id) {
        Optional<Patient> opt = patientRepository.findById(id);
        PatientDTO patient = INSTANCE.toModel(opt.get());
        if (patient.getDisease() != null){
            return patient.getDisease().getTreatment().getActionList();
        }
        return new ArrayList<ActionModel>();
    }

    @Override
    public PatientDTO findByDni(long dni) {
        Patient patient = patientRepository.findByDni(dni);
        return INSTANCE.toModel(patient);
    }

    @Override
    public List<ActionModel> findIncompleteTaskById(String id) {
        Optional<Patient> opt = patientRepository.findById(id);
        PatientDTO patientDTO = INSTANCE.toModel(opt.get());
        List<ActionModel> tasks = patientDTO.getDisease().getTreatment().getActionList();
        List<ActionModel> incompleteTask = new ArrayList<>();
        tasks.forEach(x -> {
            if (!x.isDoIt()){
                incompleteTask.add(x);
            }
        });
        return incompleteTask;
    }

    @Override
    public List<ActionModel> findCompleteTaskById(String id) {
        Optional<Patient> opt = patientRepository.findById(id);
        PatientDTO patientDTO = INSTANCE.toModel(opt.get());
        List<ActionModel> tasks = patientDTO.getDisease().getTreatment().getActionList();
        List<ActionModel> completeTask = new ArrayList<>();
        tasks.forEach(x -> {
            if (x.isDoIt()){
                completeTask.add(x);
            }
        });
        return completeTask;
    }


}
