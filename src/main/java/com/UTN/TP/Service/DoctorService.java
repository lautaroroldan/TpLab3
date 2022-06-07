package com.UTN.TP.Service;

import com.UTN.TP.Model.DoctorModel;
import com.UTN.TP.Model.PatientModel;

import java.util.HashSet;
import java.util.List;

public interface DoctorService {
    //TODO Revisar sobre el HashMap
    DoctorModel addDoctor(DoctorModel doctorModel);
    List<DoctorModel> getDoctorList();
}
