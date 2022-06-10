package com.UTN.TP.Controller;

import com.UTN.TP.Entity.Disease;
import com.UTN.TP.Entity.Patient;
import com.UTN.TP.Model.DiseaseModel;
import com.UTN.TP.Model.PatientModel;
import com.UTN.TP.Model.TreatmentModel;
import com.UTN.TP.Service.DiseaseService;
import com.UTN.TP.Service.NextSequenceService;
import com.UTN.TP.Service.PatientService;
import com.UTN.TP.Service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/diseaseController")
public class DiseaseController {

    @PostMapping("/addJson")
    public void addDisease(DiseaseModel diseaseModel){

        diseaseService.addDisease(diseaseModel);

    }

    @Autowired
    DiseaseService diseaseService;

    @Autowired
    TreatmentService treatmentService;

    @Autowired
    NextSequenceService nextSequenceService;

    @GetMapping("/addDisease")
    public ModelAndView add(){
        ModelAndView mav = new ModelAndView("addDisease");
        mav.addObject("disease", new DiseaseModel());
        mav.addObject("treatment",new TreatmentModel());
        mav.addObject("treatmentList",treatmentService.getTreatmentList());
        return mav;
    }


    @PostMapping("/add")
    public RedirectView addDisease(@ModelAttribute("disease")DiseaseModel diseaseModel, @ModelAttribute("treatment")TreatmentModel treatmentModel){
        diseaseModel.setDiseaseId(nextSequenceService.getNextSequenceDisease("customSequence"));
        RedirectView redirectView = new RedirectView("/diseaseController/findAll");
        diseaseModel.setTreatment(treatmentService.findById(treatmentModel.getId()));
        diseaseService.addDisease(diseaseModel);
        return redirectView;
    }


    @GetMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView("listDisease");
        modelAndView.addObject("listDisease", diseaseService.getDiseaseList());

        return modelAndView;
    }




}
