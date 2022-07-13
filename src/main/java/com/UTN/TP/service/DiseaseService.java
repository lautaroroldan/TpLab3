package com.UTN.TP.service;

import com.UTN.TP.dto.DiseaseDTO;

import java.util.List;

public interface DiseaseService {
    DiseaseDTO addDisease(DiseaseDTO diseaseDTO);
    List<DiseaseDTO> getDiseaseList();
    DiseaseDTO findById(String id);
}
