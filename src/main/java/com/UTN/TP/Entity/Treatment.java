package com.UTN.TP.Entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Treatment {

    private long id;

    private String name;

    private List<ActionModel> actionList;

    private Date init;

    private Date end;
}
