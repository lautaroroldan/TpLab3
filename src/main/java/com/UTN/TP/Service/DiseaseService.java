package com.UTN.TP.Service;

import com.UTN.TP.Model.DiseaseModel;
import com.UTN.TP.Model.TreatmentModel;

public interface DiseaseService {
    DiseaseModel addTreatment(DiseaseModel diseaseModel, TreatmentModel treatmentModel);
}
