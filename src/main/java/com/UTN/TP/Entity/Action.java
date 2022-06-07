package com.UTN.TP.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "action")
public class Action {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "nameAction")
    private String nameAction;

    @Column(name = "dateInit")
    private Date init;

    @Column(name = "dateEnd")
    private Date end;

    @Column(name = "doIt")
    private boolean doIt;
}
