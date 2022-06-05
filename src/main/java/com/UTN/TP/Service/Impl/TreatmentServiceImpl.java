package com.UTN.TP.Service.Impl;

import com.UTN.TP.Model.ActionModel;
import com.UTN.TP.Model.TreatmentModel;
import com.UTN.TP.Service.TreatmentService;
import org.springframework.stereotype.Service;

@Service("TreatmentServiceImpl")
public class TreatmentServiceImpl implements TreatmentService {


    @Override
    public TreatmentModel addAction(TreatmentModel treatmentModel, ActionModel actionModel) {
        treatmentModel.getActionList().add(actionModel);
        return treatmentModel;
    }
}
