package com.UTN.TP.Mapper;

import com.UTN.TP.Entity.Person;
import com.UTN.TP.dto.PersonModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person toEntity(PersonModel personModel);
    PersonModel toModel(Person person);
}
