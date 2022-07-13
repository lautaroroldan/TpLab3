package com.UTN.TP.service.imp;

import com.UTN.TP.entity.Disease;
import com.UTN.TP.mapper.DiseaseMapper;
import com.UTN.TP.dto.DiseaseDTO;
import com.UTN.TP.repository.DiseaseRepository;
import com.UTN.TP.service.DiseaseService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("DiseaseServiceImpl")
public class DiseaseServiceImpl implements DiseaseService {

    @Autowired
    DiseaseRepository diseaseRepository;

    DiseaseMapper INSTANCE = Mappers.getMapper(DiseaseMapper.class);

    @Override
    public DiseaseDTO addDisease(DiseaseDTO diseaseDTO) {
        diseaseRepository.save(INSTANCE.toEntity(diseaseDTO));
        return diseaseDTO;
    }

    @Override
    public List<DiseaseDTO> getDiseaseList() {
        List<Disease> diseases = diseaseRepository.findAll();
        List<DiseaseDTO> diseaseDTOS = new ArrayList<>();
        diseases.forEach(x -> diseaseDTOS.add(INSTANCE.toModel(x)));

        return diseaseDTOS;
    }

    @Override
    public DiseaseDTO findById(String id) {


        Optional<Disease> optionalDisease = diseaseRepository.findById(id);

        return optionalDisease.isPresent() ? INSTANCE.toModel(optionalDisease.get()) : new DiseaseDTO();
    }
}
