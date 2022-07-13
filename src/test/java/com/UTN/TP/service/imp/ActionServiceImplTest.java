package com.UTN.TP.service.imp;

import com.UTN.TP.mapper.ActionMapper;
import com.UTN.TP.service.ActionService;
import com.UTN.TP.dto.ActionDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

class ActionServiceImplTest {

    @Mock
    ActionDTO actionModel;

    @InjectMocks
    ActionMapper INSTANCE = Mappers.getMapper(ActionMapper.class);

    @Mock
    ActionService actionService;

    @Test
    void addAction() {
        actionModel = new ActionDTO("1","name1",new Date(),new Date(),false);
        when(actionService.addAction(actionModel)).thenReturn(new ActionDTO("1","name1",new Date(),new Date(),false));
        Assertions.assertEquals(actionModel.getIdAction(),actionService.addAction(actionModel).getIdAction());
        Assertions.assertEquals(actionModel.getNameAction(),actionService.addAction(actionModel).getNameAction());
        Assertions.assertEquals(actionModel.isDoIt(),actionService.addAction(actionModel).isDoIt());
    }

    @Test
    void getActionList() {
        List<ActionDTO> actionList = new ArrayList<>();
        actionList.add(new ActionDTO("id1","name1",new Date(),new Date(),false));
        actionList.add(new ActionDTO("id2","name2",new Date(),new Date(),false));
        when(actionService.getActionList()).thenReturn(actionList);

        List<ActionDTO> actions = actionService.getActionList();

        Assertions.assertEquals(2,actions.size());

    }

    @Test
    void findById() {
        when(actionService.findById("1")).thenReturn(new ActionDTO("1","nameAction",new Date(), new Date(),false));
        actionModel = actionService.findById("1");
        Assertions.assertEquals("nameAction",actionModel.getNameAction());
        Assertions.assertEquals(false,actionModel.isDoIt());
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

}