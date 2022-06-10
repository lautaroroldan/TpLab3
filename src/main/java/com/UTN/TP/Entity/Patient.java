package com.UTN.TP.Entity;

import com.UTN.TP.Model.DiseaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "patient")
public class Patient extends Person{

    private int patientId;

    private long dni;

    private Date entry;

    private boolean serve;

    private Disease disease;
}
