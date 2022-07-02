package com.UTN.TP.Service.Impl;


import com.UTN.TP.Entity.Action;
import com.UTN.TP.Mapper.ActionMapper;
import com.UTN.TP.dto.ActionDTO;
import com.UTN.TP.Repository.ActionRepository;
import com.UTN.TP.Service.ActionService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("ActionServiceImpl")
public class ActionServiceImpl implements ActionService {

    @Autowired
    ActionRepository actionRepository;

    ActionMapper INSTANCE = Mappers.getMapper(ActionMapper.class);

    @Override
    public ActionDTO addAction(ActionDTO actionDTO) {
        actionRepository.save(INSTANCE.toEntity(actionDTO));
        return actionDTO;
    }

    @Override
    public List<ActionDTO> getActionList() {
        List<Action> actions = actionRepository.findAll();
        List<ActionDTO> actionDTOS = new ArrayList<>();
        actions.forEach(x -> actionDTOS.add(INSTANCE.toModel(x)));
        return actionDTOS;
    }

    @Override
    public ActionDTO findById(String id) {
        Optional<Action> opt = actionRepository.findById(id);

        if(opt.isPresent()){
            return INSTANCE.toModel(opt.get());
        }else{
            System.out.println("Entre al else");
            return new ActionDTO();
        }
    }
}
