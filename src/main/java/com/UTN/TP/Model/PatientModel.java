package com.UTN.TP.Model;

import com.UTN.TP.Entity.Action;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PatientModel extends PersonModel{

    private String idPatient;
    private long dni;
    private Date entry;
    private DiseaseModel disease;
    private boolean serve;
    private List<ActionModel> incompleteTaskList;
}
