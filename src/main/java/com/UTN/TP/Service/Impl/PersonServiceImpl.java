package com.UTN.TP.Service.Impl;

import com.UTN.TP.Entity.Person;
import com.UTN.TP.Mapper.PersonMapper;
import com.UTN.TP.Model.PersonModel;
import com.UTN.TP.Repository.PersonRepository;
import com.UTN.TP.Service.PersonService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("PersonServiceImpl")
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Override
    public PersonModel addPerson(PersonModel personModel) {
        personRepository.save(INSTANCE.toEntity(personModel));
        return personModel;
    }

    @Override
    public List<PersonModel> getPersonList() {
        List<PersonModel> personModels = new ArrayList<>();
        List<Person> personList = personRepository.findAll();
        personList.forEach(x->personModels.add(INSTANCE.toModel(x)));
        return personModels;
    }
}
