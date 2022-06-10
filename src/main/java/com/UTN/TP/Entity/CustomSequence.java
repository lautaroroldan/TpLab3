package com.UTN.TP.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customSequence")
@Getter
@Setter
public class CustomSequence {

    @Id
    private String id;
    private int seqAdmin;
    private int seqDoctor;
    private int seqPatient;
    private int seqPerson;
    private int seqDisease;
    private int seqTreatment;
    private int seqAction;



}
