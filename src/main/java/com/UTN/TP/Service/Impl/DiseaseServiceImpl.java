package com.UTN.TP.Service.Impl;

import com.UTN.TP.Entity.Disease;
import com.UTN.TP.Mappers.DiseaseMapper;
import com.UTN.TP.Model.DiseaseModel;
import com.UTN.TP.Model.TreatmentModel;
import com.UTN.TP.Repository.DiseaseRepository;
import com.UTN.TP.Service.DiseaseService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service("DiseaseServiceImpl")
public class DiseaseServiceImpl implements DiseaseService {

    @Autowired
    DiseaseRepository diseaseRepository;

    DiseaseMapper INSTANCE = Mappers.getMapper(DiseaseMapper.class);

    @Override
    public DiseaseModel addDisease(DiseaseModel diseaseModel) {
        diseaseRepository.save(INSTANCE.toEntity(diseaseModel));
        return diseaseModel;
    }

    @Override
    public List<DiseaseModel> getDiseaseList() {
        List<Disease> diseases = diseaseRepository.findAll();
        List<DiseaseModel> diseaseModels = new ArrayList<>();
        diseases.forEach(x -> diseaseModels.add(INSTANCE.toModel(x)));

        return diseaseModels;
    }

    @Override
    public DiseaseModel findById(Integer id) {

        String pase = Integer.toString(id);
        Optional<Disease> optionalDisease = diseaseRepository.findById(pase);

        if(optionalDisease.isPresent()){
            return INSTANCE.toModel(optionalDisease.get());
        }else{
            System.out.println("Entre al else");
            return new DiseaseModel();
        }
    }
}
