package com.UTN.TP.service;

import com.UTN.TP.dto.ActionDTO;

import java.util.List;


public interface ActionService {

    ActionDTO addAction(ActionDTO actionDTO);
    List<ActionDTO> getActionList();
    ActionDTO findById(String id);


}
