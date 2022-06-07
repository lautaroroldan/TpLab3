package com.UTN.TP.Entity;

import com.UTN.TP.Model.DiseaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class Patient extends Person{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "dni")
    private long dni;

    @Column(name = "entryDate")
    private Date entry;

    @Column(name = "disease")
    private Disease disease;

    @Column(name = "serve")
    private boolean serve;
}
