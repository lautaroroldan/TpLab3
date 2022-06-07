package com.UTN.TP.Model;

import lombok.Data;

import java.util.Date;

@Data
public class ActionModel {
    private long id;
    private String nameAction;
    private Date init;
    private Date end;
    private boolean doIt;
}
