package com.UTN.TP.Controller;

import com.UTN.TP.Entity.Disease;
import com.UTN.TP.Entity.Patient;
import com.UTN.TP.Model.DiseaseModel;
import com.UTN.TP.Model.PatientModel;
import com.UTN.TP.Service.DiseaseService;
import com.UTN.TP.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("diseaseController")
public class DiseaseController {

    @Autowired
    DiseaseService diseaseService;

    @PostMapping("addDisease")
    public void addDisease(@RequestBody DiseaseModel diseaseModel){

        diseaseService.addDisease(diseaseModel);

    }

    @GetMapping("findAll")
    public List<DiseaseModel> findAll(){
        return diseaseService.getDiseaseList();
    }




}
