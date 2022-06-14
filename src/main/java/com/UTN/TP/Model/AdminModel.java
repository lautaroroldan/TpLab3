package com.UTN.TP.Model;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AdminModel extends PersonModel{

    private String idAdmin;
    private String adminRol;

}