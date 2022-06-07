package com.UTN.TP.Mappers;

import com.UTN.TP.Entity.Action;
import com.UTN.TP.Entity.Patient;
import com.UTN.TP.Model.ActionModel;
import com.UTN.TP.Model.PatientModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActionMapper {
    ActionMapper INSTANCE = Mappers.getMapper(ActionMapper.class);

    Action toEntity(ActionModel actionModel);
    ActionModel toModel(Action action);
}
