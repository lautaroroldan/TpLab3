package com.UTN.TP.Entity;

import com.UTN.TP.Service.ActionService;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Treatment {

    private long id;

    private String name;

    private List<Action> actionList;

    private Date init;

    private Date end;
}
