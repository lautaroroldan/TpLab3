package com.UTN.TP.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admin")
public class Admin extends Person{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
}
