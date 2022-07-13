package com.UTN.TP.service;

import com.UTN.TP.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    PersonDTO addPerson(PersonDTO personDTO);
    List<PersonDTO> getPersonList();
}
