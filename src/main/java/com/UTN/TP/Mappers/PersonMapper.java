package com.UTN.TP.Mappers;

import com.UTN.TP.Entity.Patient;
import com.UTN.TP.Entity.Person;
import com.UTN.TP.Model.PatientModel;
import com.UTN.TP.Model.PersonModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person toEntity(PersonModel personModel);
    PersonModel toModel(Person person);
}
