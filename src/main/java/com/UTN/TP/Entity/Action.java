package com.UTN.TP.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "action")
public class Action {

    @Id
    private String idAction;

    private String nameAction;

    private Date init;

    private Date end;

   private boolean doIt;
}
