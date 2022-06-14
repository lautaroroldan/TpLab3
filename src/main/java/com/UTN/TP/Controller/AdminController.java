package com.UTN.TP.Controller;

import com.UTN.TP.Entity.Patient;
import com.UTN.TP.Model.AdminModel;
import com.UTN.TP.Model.DoctorModel;
import com.UTN.TP.Model.PatientModel;
import com.UTN.TP.Service.AdminService;
import com.UTN.TP.Service.DoctorService;
import com.UTN.TP.Service.PatientService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;


@RestController
@RequestMapping("/adminController")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientService patientService;

    private static final Log LOG = LogFactory.getLog(AdminController.class);


    @GetMapping("/addAdmin")
    ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView("addAdmin");
        modelAndView.addObject("admin",new AdminModel());

        return modelAndView;
    }

    @PostMapping("/add")
    public RedirectView addAdmin(@ModelAttribute("admin") AdminModel adminModel){


        RedirectView redirectView = new RedirectView("/adminController/addAdmin");
        adminService.addAdmin(adminModel);

        return redirectView;
    }



    @GetMapping("/findAll")
    public ModelAndView findAll(){

        ModelAndView modelAndView = new ModelAndView("listAction");
        modelAndView.addObject("listAction1", adminService.getAdminList());
        return modelAndView;
    }

    @GetMapping("/{doctorId}")
    public ModelAndView addPatientDoctor(@PathVariable(value = "doctorId") String id){
        ModelAndView mav = new ModelAndView("addPatientToDoctor");
        mav.addObject("doctor",doctorService.findById(id));
        LOG.info(doctorService.findById(id).getPatients());
        mav.addObject("patientsList",patientService.getPatientList());
        mav.addObject("patient",new PatientModel());
        LOG.info(id + "ID : addPatientDoctor ");
        return mav;
    }

    @PostMapping("/addPatient")
    public RedirectView addPatient(@ModelAttribute("doctor")DoctorModel doctorModel, @ModelAttribute("patient")PatientModel idPatient){
        LOG.info("ID DOCTOR : "+ doctorModel.getIdDoctor());
        DoctorModel doc = doctorService.findById(doctorModel.getIdDoctor());
        LOG.info("El id del paciente es "+ idPatient.getIdPatient());
        PatientModel patient = patientService.findById(idPatient.getIdPatient());
        doc.getPatients().put(patient.getIdPatient(),patient);
        doctorService.addDoctor(doc);
        return new RedirectView("/doctorController/findAll");
    }

}
