package com.UTN.TP.Model;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DiseaseModel {
    private String id;
    private Integer diseaseId;
    private String name;
    private TreatmentModel treatment;
}
