package com.UTN.TP.Model;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
public class TreatmentModel {
    private long id;
    private String name;
    private List<ActionModel> actionList;
    private Date init;
    private Date end;
}
