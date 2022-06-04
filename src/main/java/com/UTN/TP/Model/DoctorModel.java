package com.UTN.TP.Model;

import lombok.*;

import java.util.HashMap;


@Data
public class DoctorModel extends PersonModel{
    private long id;
    private HashMap<String,PatientModel> patients;
}
