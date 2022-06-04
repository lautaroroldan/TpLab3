package com.UTN.TP.Model;

import lombok.*;

import java.util.Date;


@Data
public class PatientModel extends PersonModel{
    private long id;
    private long dni;
    private Date entry;
    private DiseaseModel disease;
    private boolean serve;

}
