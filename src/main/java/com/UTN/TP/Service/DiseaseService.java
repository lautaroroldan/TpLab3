package com.UTN.TP.Service;

import com.UTN.TP.dto.DiseaseModel;

import java.util.List;

public interface DiseaseService {
    DiseaseModel addDisease(DiseaseModel diseaseModel);
    List<DiseaseModel> getDiseaseList();
    DiseaseModel findById(String id);
}
