package com.UTN.TP.Model;

import lombok.*;

import java.util.HashMap;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DoctorModel extends PersonModel{


    private int doctorId;

    ///Todo revisar sobre el Hashmap
    private HashMap<String,PatientModel> patients;
}
