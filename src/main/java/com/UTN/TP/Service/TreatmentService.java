package com.UTN.TP.Service;

import com.UTN.TP.Model.ActionModel;
import com.UTN.TP.Model.TreatmentModel;

import java.util.List;

public interface TreatmentService {

    TreatmentModel addTreatment(TreatmentModel treatmentModel);
    List<TreatmentModel> getTreatmentList();
}
