package com.UTN.TP.Service;

import com.UTN.TP.Model.DoctorModel;
import com.UTN.TP.Model.PatientModel;

import java.util.HashSet;

public interface DoctorService {
    //TODO Revisar sobre el HashMap
    PatientModel addPatient(DoctorModel doctorModel, PatientModel patientModel);
}
