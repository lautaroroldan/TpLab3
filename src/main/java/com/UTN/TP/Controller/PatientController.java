package com.UTN.TP.Controller;

import com.UTN.TP.Mappers.DiseaseMapper;
import com.UTN.TP.Model.DiseaseModel;
import com.UTN.TP.Model.PatientModel;
import com.UTN.TP.Service.DiseaseService;
import com.UTN.TP.Service.PatientService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/patientController")
public class PatientController {

    private static final Log LOG = LogFactory.getLog(PatientController.class);

    @Autowired
    PatientService patientService;

    @Autowired
    DiseaseService diseaseService;

    @GetMapping("/addPatient")
    ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView("addPatient");

        Integer i = new Integer(-1);

        modelAndView.addObject("patient",new PatientModel());
        modelAndView.addObject("identifier",i);


        modelAndView.addObject("diseaseList",diseaseService.getDiseaseList());
        return modelAndView;
    }

    @PostMapping("/add")
    public RedirectView addPatient(@ModelAttribute("patient")PatientModel patientModel,@ModelAttribute("identifier")Integer i){


        LOG.info("ya pase por el toString :");

        RedirectView redirectView = new RedirectView("/patientController/findAll");

        DiseaseModel diseaseModel = new DiseaseModel();
        diseaseModel = diseaseService.findById(i);

        patientModel.setDisease(diseaseModel);
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
