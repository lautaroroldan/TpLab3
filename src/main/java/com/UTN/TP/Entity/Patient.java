package com.UTN.TP.Entity;

import com.UTN.TP.Model.DiseaseModel;
import lombok.Data;

import java.util.Date;

@Data
public class Patient extends Person{

    private long id;

    private long dni;

    private Date entry;

    private Disease disease;

    private boolean serve;
}
