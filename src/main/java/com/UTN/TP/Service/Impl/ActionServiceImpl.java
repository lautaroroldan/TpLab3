package com.UTN.TP.Service.Impl;


import com.UTN.TP.Entity.Action;
import com.UTN.TP.Entity.Disease;
import com.UTN.TP.Mappers.ActionMapper;
import com.UTN.TP.Model.ActionModel;
import com.UTN.TP.Repository.ActionRepository;
import com.UTN.TP.Service.ActionService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ActionServiceImpl")
public class ActionServiceImpl implements ActionService {

    @Autowired
    ActionRepository actionRepository;

    ActionMapper INSTANCE = Mappers.getMapper(ActionMapper.class);

    @Override
    public ActionModel addAction(ActionModel actionModel) {
        actionRepository.save(INSTANCE.toEntity(actionModel));
        return actionModel;
    }

    @Override
    public List<ActionModel> getActionList() {
        List<Action> actions = actionRepository.findAll();
        List<ActionModel> actionModels = new ArrayList<>();
        actions.forEach(x -> actionModels.add(INSTANCE.toModel(x)));
        return actionModels;
    }
}
