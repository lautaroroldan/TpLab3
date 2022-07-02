package com.UTN.TP.dto;

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
<<<<<<< HEAD:src/main/java/com/UTN/TP/dto/PatientModel.java
    private List<ActionDTO> incompleteTaskList;

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public Date getEntry() {
        return entry;
    }

    public void setEntry(Date entry) {
        this.entry = entry;
    }

    public DiseaseModel getDisease() {
        return disease;
    }

    public void setDisease(DiseaseModel disease) {
        this.disease = disease;
    }

    public boolean isServe() {
        return serve;
    }

    public void setServe(boolean serve) {
        this.serve = serve;
    }

    public List<ActionDTO> getIncompleteTaskList() {
        return incompleteTaskList;
    }

    public void setIncompleteTaskList(List<ActionDTO> incompleteTaskList) {
        this.incompleteTaskList = incompleteTaskList;
    }


=======
    private List<ActionModel> incompleteTaskList;
>>>>>>> 96235ac0df5e1f30a334c0082e404e3cf440a052:src/main/java/com/UTN/TP/Model/PatientModel.java
}
