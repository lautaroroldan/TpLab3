package com.UTN.TP.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "admin")
public class Admin extends Person{

    @Id
    private String idAdmin;
    private String adminRol;


}
