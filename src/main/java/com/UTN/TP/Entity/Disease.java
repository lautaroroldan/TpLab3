package com.UTN.TP.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(value = "disease")
public class Disease {

    @Id
    private String id;

    private int diseaseId;

    private String name;

    private Treatment treatment;

}
