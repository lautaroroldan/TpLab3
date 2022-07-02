package com.UTN.TP.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentModel {
    private String idTreatment;
    private String name;
    private List<ActionDTO> actionList;
    private Date init;
    private Date end;
}
