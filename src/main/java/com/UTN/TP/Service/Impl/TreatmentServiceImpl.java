package com.UTN.TP.Service.Impl;

import com.UTN.TP.Entity.Treatment;
import com.UTN.TP.Mapper.TreatmentMapper;
import com.UTN.TP.Model.TreatmentModel;
import com.UTN.TP.Repository.TreatmentRepository;
import com.UTN.TP.Service.TreatmentService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("TreatmentServiceImpl")
public class TreatmentServiceImpl implements TreatmentService {

    @Autowired
    TreatmentRepository treatmentRepository;

    TreatmentMapper INSTANCE = Mappers.getMapper(TreatmentMapper.class);

    @Override
    public TreatmentModel addTreatment(TreatmentModel treatmentModel) {
        treatmentRepository.save(INSTANCE.toEntity(treatmentModel));
        return treatmentModel;
    }

    @Override
    public List<TreatmentModel> getTreatmentList() {
        List<Treatment> treatments = treatmentRepository.findAll();
        List<TreatmentModel> treatmentModels = new ArrayList<>();
        treatments.forEach(x -> treatmentModels.add(INSTANCE.toModel(x)));
        return treatmentModels;
    }

    @Override
    public TreatmentModel findById(String id) {
        Optional<Treatment> opt = treatmentRepository.findById(id);
        if (opt.isPresent()){
            return INSTANCE.toModel(opt.get());
        }else return new TreatmentModel();
    }
}
