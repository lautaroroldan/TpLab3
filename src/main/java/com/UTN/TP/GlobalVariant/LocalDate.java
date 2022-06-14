package com.UTN.TP.GlobalVariant;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LocalDate {
    private static LocalDateTime GlobalDate = LocalDateTime.now();
}
