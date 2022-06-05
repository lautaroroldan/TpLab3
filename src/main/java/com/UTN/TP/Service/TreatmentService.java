package com.UTN.TP.Service;

import com.UTN.TP.Model.ActionModel;
import com.UTN.TP.Model.TreatmentModel;

public interface TreatmentService {

    TreatmentModel addAction(TreatmentModel treatmentModel, ActionModel actionModel);
}
