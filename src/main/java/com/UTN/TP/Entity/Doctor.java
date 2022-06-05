package com.UTN.TP.Entity;

import com.UTN.TP.Model.PatientModel;
import lombok.Data;

import java.util.HashMap;

@Data
public class Doctor extends Person{

    private long id;

    private HashMap<String, Patient> patients;
}
