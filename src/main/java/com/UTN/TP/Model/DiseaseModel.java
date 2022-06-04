package com.UTN.TP.Model;

import lombok.*;

@Data
public class DiseaseModel {
    private long id;
    private String name;
    private TreatmentModel treatment;
}
