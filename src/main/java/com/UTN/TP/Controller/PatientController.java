package com.UTN.TP.Controller;

import com.UTN.TP.Model.DiseaseModel;
import com.UTN.TP.Model.PatientModel;
import com.UTN.TP.Service.DiseaseService;
import com.UTN.TP.Service.NextSequenceService;
import com.UTN.TP.Service.PatientService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/patientController")
public class PatientController {

    private static final Log LOG = LogFactory.getLog(PatientController.class);

    @Autowired
    PatientService patientService;

    @Autowired
    DiseaseService diseaseService;

    @Autowired
    NextSequenceService nextSequenceService;

    @GetMapping("/addPatient")
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView("addPatient");


        modelAndView.addObject("patient",new PatientModel());
        modelAndView.addObject("diseaseModel",new DiseaseModel());
        modelAndView.addObject("diseaseList",diseaseService.getDiseaseList());
        return modelAndView;
    }

    @PostMapping("/add")
    public RedirectView addPatient(@ModelAttribute("patient")PatientModel patientModel,@ModelAttribute("diseaseModel")DiseaseModel diseaseModel){


        LOG.info("ya pase por el toString :");
        patientModel.setPatientId(nextSequenceService.getNextSequencePatient("customSequence"));
        RedirectView redirectView = new RedirectView("/patientController/findAll");
        patientModel.setDisease(diseaseService.findById(diseaseModel.getDiseaseId()));
        patientService.addPatient(patientModel);

        return redirectView;
    }

    @GetMapping("/findAll")
    public ModelAndView findAll(){

        ModelAndView modelAndView = new ModelAndView("listPatient");
        modelAndView.addObject("listPatient", patientService.getPatientList());

        return modelAndView;
    }


}
