package com.UTN.TP.Service;

import com.UTN.TP.dto.ActionDTO;

import java.util.List;


public interface ActionService {

    ActionDTO addAction(ActionDTO actionDTO);
    List<ActionDTO> getActionList();
    ActionDTO findById(String id);


}
