package com.UTN.TP.Controller;

import com.UTN.TP.Entity.Patient;
import com.UTN.TP.Model.DiseaseModel;
import com.UTN.TP.Model.DoctorModel;
import com.UTN.TP.Model.PatientModel;
import com.UTN.TP.Model.TreatmentModel;
import com.UTN.TP.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;

@RestController
@RequestMapping("/doctorController")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientService patientService;



    @GetMapping("/addDoctor")
    public ModelAndView add(){
        ModelAndView mav = new ModelAndView("addDoctor");
        mav.addObject("doctor", new DoctorModel());
        return mav;
    }


    @PostMapping("/add")
    public RedirectView addDoctor(@ModelAttribute("doctor")DoctorModel doctorModel){
        RedirectView redirectView = new RedirectView("/doctorController/findAll");
        doctorModel.setPatients(new HashMap<>());
        doctorService.addDoctor(doctorModel);
        return redirectView;
    }


    @GetMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView("listDoctor");
        modelAndView.addObject("listDoctor", doctorService.getDoctorList());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView viewPatients(@PathVariable String id){
        ModelAndView mav = new ModelAndView("patientListDoctor");
        mav.addObject("doctor", doctorService.findById(id));
        return mav;
    }

    @GetMapping("/doctor/{id}")
    public ModelAndView viewDoctor(@PathVariable(value = "id")String id){
        ModelAndView mav = new ModelAndView("profileDoctor");
        mav.addObject("doctor",doctorService.findById(id));
        return mav;
    }


}
