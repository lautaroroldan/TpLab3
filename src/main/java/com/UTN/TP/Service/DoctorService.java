package com.UTN.TP.Service;

import com.UTN.TP.dto.DoctorModel;

import java.util.List;

public interface DoctorService {
    //TODO Revisar sobre el HashMap
    DoctorModel addDoctor(DoctorModel doctorModel);
    List<DoctorModel> getDoctorList();
    DoctorModel findById(String id);
}
