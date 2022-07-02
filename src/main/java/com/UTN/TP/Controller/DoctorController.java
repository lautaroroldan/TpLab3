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

    @Autowired
    DiseaseService diseaseService;

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

    @GetMapping("/patients/{id}")
    public ModelAndView viewPatients(@PathVariable(value = "id") String id){
        ModelAndView mav = new ModelAndView("patientListDoctor");
        mav.addObject("doctor", doctorService.findById(id));
        mav.addObject("patientMap",doctorService.findById(id).getPatients());
        return mav;
    }

    @GetMapping("/patient/{idDoctor}/{idPatient}")
    public ModelAndView viewPatientProfile(@PathVariable (value = "idDoctor")String idDoctor,@PathVariable(value = "idPatient")String idPatient){
        ModelAndView mav = new ModelAndView("profilePatientServe");
        mav.addObject("doctor", doctorService.findById(idDoctor));
        mav.addObject("patient",patientService.findById(idPatient));
        LOG.info("PATIENT ID : "+patientService.findById(idPatient));
        mav.addObject("disease",new DiseaseModel());
        mav.addObject("diseaseList",diseaseService.getDiseaseList());
        LOG.info("DOCTOR ID : " + doctorService.findById(idDoctor));
        return mav;
    }

    @GetMapping("/doctor/{id}")
    public ModelAndView viewDoctor(@PathVariable(value = "id")String id){
        ModelAndView mav = new ModelAndView("profileDoctor");
        mav.addObject("doctor",doctorService.findById(id));
        return mav;
    }

//    @GetMapping("/patientDisease/{patientId}")
//    public ModelAndView addDiseaseToPatient(@PathVariable(value = "patientId")String patientid){
//        ModelAndView modelAndView = new ModelAndView("addDiseaseToPatient");
//        modelAndView.addObject("patient",patientService.findById(patientid));
//        modelAndView.addObject("diseaseModel",new DiseaseModel());
//        modelAndView.addObject("diseaseList",diseaseService.getDiseaseList());
//        return modelAndView;
//    }

    @PostMapping("/addDiseaseToPatient/{idDoctor}/{idPatient}")
    public RedirectView postDiseaseToPatient(@ModelAttribute("doctor")DoctorModel doctorModel, @ModelAttribute("patient")PatientModel patientModel, @ModelAttribute("disease")DiseaseModel diseaseModel){
        LOG.info("FIND BY ID PATIENT : " + patientService.findById(patientModel.getIdPatient()));
        PatientModel patient = patientService.findById(patientModel.getIdPatient());
        DoctorModel doctor = doctorService.findById(doctorModel.getIdDoctor());
        DiseaseModel disease = diseaseService.findById(diseaseModel.getIdDisease());
        doctor.getPatients().get(patient.getIdPatient()).setDisease(diseaseService.findById(disease.getIdDisease()));
        doctor.getPatients().get(patient.getIdPatient()).setServe(true);
        patient.setServe(true);
        patient.setDisease(diseaseService.findById(disease.getIdDisease()));
        LOG.info("FIND BY ID DISEASE : " + diseaseService.findById(disease.getIdDisease()));
        patientService.addPatient(patient);
        doctorService.addDoctor(doctor);
        return new RedirectView("/doctorController/patient/"+doctor.getIdDoctor() + "/" + patient.getIdPatient());
    }



}
