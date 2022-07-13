package com.UTN.TP.service;

import com.UTN.TP.dto.TreatmentDTO;

import java.util.List;

public interface TreatmentService {

    TreatmentDTO addTreatment(TreatmentDTO treatmentDTO);
    List<TreatmentDTO> getTreatmentList();
    TreatmentDTO findById(String id);
}
