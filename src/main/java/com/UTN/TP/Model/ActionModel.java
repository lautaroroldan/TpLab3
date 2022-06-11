package com.UTN.TP.Model;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ActionModel {
    private String id;
    private String nameAction;
    private Date init;
    private Date end;
    private boolean doIt;
}
