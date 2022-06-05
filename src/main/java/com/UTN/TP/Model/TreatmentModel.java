package com.UTN.TP.Model;

import com.UTN.TP.Service.ActionService;
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
