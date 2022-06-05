package com.UTN.TP.Entity;

import lombok.Data;

import java.util.Date;

@Data
public class Action {
    private long id;
    private String nameAction;
    private Date init;
    private Date end;
    private boolean doIt;
}
