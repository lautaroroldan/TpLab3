package com.UTN.TP.Model;

import lombok.*;

import java.util.Date;



@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PatientModel extends PersonModel{

    private int patientId;
    private long dni;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

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

    private Date entry;
    private DiseaseModel disease;
    private boolean serve;

}
