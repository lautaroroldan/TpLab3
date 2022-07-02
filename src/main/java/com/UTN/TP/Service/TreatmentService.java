package com.UTN.TP.Service;

import com.UTN.TP.dto.TreatmentModel;

import java.util.List;

public interface TreatmentService {

    TreatmentModel addTreatment(TreatmentModel treatmentModel);
    List<TreatmentModel> getTreatmentList();
    TreatmentModel findById(String id);
}
