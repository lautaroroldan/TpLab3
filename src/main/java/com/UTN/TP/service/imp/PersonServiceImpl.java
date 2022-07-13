package com.UTN.TP.service.imp;

import com.UTN.TP.entity.Person;
import com.UTN.TP.mapper.PersonMapper;
import com.UTN.TP.dto.PersonDTO;
import com.UTN.TP.repository.PersonRepository;
import com.UTN.TP.service.PersonService;
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
    public PersonDTO addPerson(PersonDTO personDTO) {
        personRepository.save(INSTANCE.toEntity(personDTO));
        return personDTO;
    }

    @Override
    public List<PersonDTO> getPersonList() {
        List<PersonDTO> personDTOS = new ArrayList<>();
        List<Person> personList = personRepository.findAll();
        personList.forEach(x-> personDTOS.add(INSTANCE.toModel(x)));
        return personDTOS;
    }
}
