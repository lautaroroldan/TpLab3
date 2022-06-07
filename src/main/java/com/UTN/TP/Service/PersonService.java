package com.UTN.TP.Service;

import com.UTN.TP.Model.PersonModel;

import java.util.List;

public interface PersonService {
    PersonModel addPerson(PersonModel personModel);
    List<PersonModel> getPersonList();
}
