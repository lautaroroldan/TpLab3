package com.UTN.TP.Service.Impl;

import com.UTN.TP.Entity.Patient;
import com.UTN.TP.Mapper.PatientMapper;
import com.UTN.TP.Model.ActionModel;
import com.UTN.TP.Model.PatientModel;
import com.UTN.TP.Repository.DoctorRepository;
import com.UTN.TP.Repository.PatientRepository;
import com.UTN.TP.Service.DoctorService;
import com.UTN.TP.Service.PatientService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
    public PatientModel addPatient(PatientModel patientModel) {
        patientRepository.save(INSTANCE.toEntity(patientModel));
        return patientModel;
    }

    @Override
    public List<PatientModel> getPatientList() {
        List<PatientModel> patientModels = new ArrayList<>();
        List<Patient> patients = patientRepository.findAll();
        patients.forEach(x->patientModels.add(INSTANCE.toModel(x)));
        return patientModels;
    }

    public PatientModel findById(String id){
        Optional<Patient> opt = patientRepository.findById(id);
        return INSTANCE.toModel(opt.get());

    }

    @Override
    public void deletePatient(String id) {
        doctorService.deletePatient(id);
        patientRepository.deleteById(id);
    }

    @Override
    public List<PatientModel> findAllByServe(boolean choice) {
        List<PatientModel> patientModels = new ArrayList<>();
        patientRepository.findAllByServe(false).forEach(x-> patientModels.add(INSTANCE.toModel(x)));
        return patientModels;
    }

    @Override
    public List<ActionModel> findTasksById(String id) {
        Optional<Patient> opt = patientRepository.findById(id);
        PatientModel patient = INSTANCE.toModel(opt.get());
        if (patient.getDisease() != null){
            return patient.getDisease().getTreatment().getActionList();
        }
        return new ArrayList<ActionModel>();
    }

    @Override
    public PatientModel findByDni(long dni) {
        Patient patient = patientRepository.findByDni(dni);
        return INSTANCE.toModel(patient);
    }

    @Override
    public List<ActionModel> findIncompleteTaskById(String id) {
        Optional<Patient> opt = patientRepository.findById(id);
        PatientModel patientModel = INSTANCE.toModel(opt.get());
        List<ActionModel> tasks = patientModel.getDisease().getTreatment().getActionList();
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
        PatientModel patientModel = INSTANCE.toModel(opt.get());
        List<ActionModel> tasks = patientModel.getDisease().getTreatment().getActionList();
        List<ActionModel> completeTask = new ArrayList<>();
        tasks.forEach(x -> {
            if (x.isDoIt()){
                completeTask.add(x);
            }
        });
        return completeTask;
    }


}
