package com.UTN.TP.Service;

import com.UTN.TP.Entity.Disease;
import com.UTN.TP.Model.DiseaseModel;
import com.UTN.TP.Model.TreatmentModel;

import java.util.List;

public interface DiseaseService {
    DiseaseModel addDisease(DiseaseModel diseaseModel);
    List<DiseaseModel> getDiseaseList();
}
