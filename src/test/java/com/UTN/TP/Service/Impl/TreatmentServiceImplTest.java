package com.UTN.TP.Service.Impl;

import com.UTN.TP.Controller.TreatmentController;
import com.UTN.TP.Model.ActionModel;
import com.UTN.TP.Model.TreatmentModel;
import com.UTN.TP.Service.TreatmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TreatmentServiceImplTest {

    @Mock
    TreatmentService treatmentService;

    @Mock
    TreatmentModel treatmentModel;

    @Mock
    ActionModel actionModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        actionModel = new ActionModel("1Action","nameAction",new Date(),new Date(),false);
    }

    @Test
    void addTreatment() {
        List<ActionModel> actions = new ArrayList<>();
        actions.add(actionModel);
        treatmentModel = new TreatmentModel("1","treatment1",actions,new Date(),new Date());
        when(treatmentService.addTreatment(treatmentModel)).thenReturn(treatmentModel);
        assertEquals(treatmentModel.getIdTreatment(),treatmentService.addTreatment(treatmentModel).getIdTreatment());
        assertEquals(treatmentModel.getActionList().size(),treatmentService.addTreatment(treatmentModel).getActionList().size());
    }

    @Test
    void getTreatmentList() {
        List<ActionModel> actions = new ArrayList<>();
        actions.add(actionModel);
        treatmentModel = new TreatmentModel("1","treatment1",actions,new Date(),new Date());
        List<TreatmentModel> treatments = new ArrayList<>();
        treatments.add(treatmentModel);
        when(treatmentService.getTreatmentList()).thenReturn(treatments);

        assertEquals(treatments.size(),treatmentService.getTreatmentList().size());
    }

    @Test
    void findById() {
        List<ActionModel> actions = new ArrayList<>();
        actions.add(actionModel);
        treatmentModel = new TreatmentModel("1","treatment1",actions,new Date(),new Date());
        when(treatmentService.findById(treatmentModel.getIdTreatment())).thenReturn(treatmentModel);

        assertEquals(treatmentModel.getName(),treatmentService.findById(treatmentModel.getIdTreatment()).getName());
    }
}