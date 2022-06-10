package com.UTN.TP.Mapper;

import com.UTN.TP.Entity.Action;
import com.UTN.TP.Model.ActionModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActionMapper {

    ActionMapper INSTANCE = Mappers.getMapper(ActionMapper.class);

    Action toEntity(ActionModel actionModel);
    ActionModel toModel(Action action);
}