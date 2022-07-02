package com.UTN.TP.Controller;

import com.UTN.TP.dto.DoctorModel;
import com.UTN.TP.dto.PatientModel;
import com.UTN.TP.Service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

    private static final Log LOG = LogFactory.getLog(DoctorController.class);

    @GetMapping("/addDoctor")
    public ModelAndView add(){
        ModelAndView mav = new ModelAndView("addDoctor");
        mav.addObject("doctor", new DoctorModel());
        return mav;
    }


    @PostMapping("/add")
    public RedirectView addDoctor(@ModelAttribute("doctor")DoctorModel doctorModel){
        RedirectView redirectView = new RedirectView("/doctorController/findAll");
        HashMap<String,PatientModel> hashMap = new HashMap<>();
        doctorModel.setPatients(hashMap);
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
        LOG.info(doctorService.findById(id).getPatients());
        return mav;
    }

    @GetMapping("/doctor/{id}")
    public ModelAndView viewDoctor(@PathVariable(value = "id")String id){
        ModelAndView mav = new ModelAndView("profileDoctor");
        mav.addObject("doctor",doctorService.findById(id));
        return mav;
    }


}
