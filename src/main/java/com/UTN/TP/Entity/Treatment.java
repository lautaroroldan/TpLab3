package com.UTN.TP.Entity;

import com.UTN.TP.Model.ActionModel;
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
