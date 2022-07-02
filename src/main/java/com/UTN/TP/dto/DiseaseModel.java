package com.UTN.TP.dto;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DiseaseModel {
    private String idDisease;
    private String name;
    private TreatmentModel treatment;
}
