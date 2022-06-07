package com.UTN.TP.Entity;

import com.UTN.TP.Service.ActionService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "treatment")
public class Treatment {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "actionList")
    private List<Action> actionList;

    @Column(name = "dateInit")
    private Date init;

    @Column(name = "dateEnd")
    private Date end;
}
