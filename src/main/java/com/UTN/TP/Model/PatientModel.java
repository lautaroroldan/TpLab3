package com.UTN.TP.Model;

import com.UTN.TP.Entity.Action;
import lombok.*;

import java.util.Date;
import java.util.List;


@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PatientModel extends PersonModel{

    private String id;
    private long dni;
    private Date entry;
    private DiseaseModel disease;
    private boolean serve;
    private List<ActionModel> incompleteTaskList;

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

    public List<ActionModel> getIncompleteTaskList() {
        return incompleteTaskList;
    }

    public void setIncompleteTaskList(List<ActionModel> incompleteTaskList) {
        this.incompleteTaskList = incompleteTaskList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
