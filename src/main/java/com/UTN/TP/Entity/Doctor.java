package com.UTN.TP.Entity;

import com.UTN.TP.Model.PatientModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctor")
public class Doctor extends Person{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "patients")
    private HashMap<String, Patient> patients;
}
