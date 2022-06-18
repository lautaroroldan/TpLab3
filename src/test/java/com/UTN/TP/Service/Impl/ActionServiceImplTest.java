package com.UTN.TP.Service.Impl;

import com.UTN.TP.Entity.Action;
import com.UTN.TP.Mapper.ActionMapper;
import com.UTN.TP.Model.ActionModel;
import com.UTN.TP.Service.ActionService;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ActionServiceImplTest {

    @Mock
    ActionModel actionModel;

    @InjectMocks
    ActionMapper INSTANCE = Mappers.getMapper(ActionMapper.class);

    @Mock
    ActionService actionService;

    @Test
    void addAction() {
        actionModel = new ActionModel("1","name1",new Date(),new Date(),false);
        when(actionService.addAction(actionModel)).thenReturn(new ActionModel("1","name1",new Date(),new Date(),false));
        Assertions.assertEquals(actionModel.getIdAction(),actionService.addAction(actionModel).getIdAction());
        Assertions.assertEquals(actionModel.getNameAction(),actionService.addAction(actionModel).getNameAction());
        Assertions.assertEquals(actionModel.isDoIt(),actionService.addAction(actionModel).isDoIt());
    }

    @Test
    void getActionList() {
        List<ActionModel> actionList = new ArrayList<>();
        actionList.add(new ActionModel("id1","name1",new Date(),new Date(),false));
        actionList.add(new ActionModel("id2","name2",new Date(),new Date(),false));
        when(actionService.getActionList()).thenReturn(actionList);

        List<ActionModel> actions = actionService.getActionList();

        Assertions.assertEquals(2,actions.size());

    }

    @Test
    void findById() {
        when(actionService.findById("1")).thenReturn(new ActionModel("1","nameAction",new Date(), new Date(),false));
        actionModel = actionService.findById("1");
        Assertions.assertEquals("nameAction",actionModel.getNameAction());
        Assertions.assertEquals(false,actionModel.isDoIt());
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

}