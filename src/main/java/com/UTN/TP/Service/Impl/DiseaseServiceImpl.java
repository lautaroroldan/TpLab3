package com.UTN.TP.Service.Impl;

import com.UTN.TP.Model.DiseaseModel;
import com.UTN.TP.Model.TreatmentModel;
import com.UTN.TP.Service.DiseaseService;
import org.springframework.stereotype.Service;

@Service("DiseaseServiceImpl")
public class DiseaseServiceImpl implements DiseaseService {

    @Override
    public DiseaseModel addTreatment(DiseaseModel diseaseModel, TreatmentModel treatmentModel) {
        diseaseModel.setTreatment(treatmentModel);
        return diseaseModel;
    }
}
