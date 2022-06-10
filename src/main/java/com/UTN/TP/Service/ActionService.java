package com.UTN.TP.Service;

import com.UTN.TP.Model.ActionModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


public interface ActionService {

    ActionModel addAction(ActionModel actionModel);
    List<ActionModel> getActionList();
    ActionModel findById(String id);


}
