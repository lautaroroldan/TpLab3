package com.UTN.TP.Controller;

import com.UTN.TP.Model.DiseaseModel;
import com.UTN.TP.Model.DoctorModel;
import com.UTN.TP.Model.PatientModel;
import com.UTN.TP.Service.DiseaseService;
import com.UTN.TP.Service.DoctorService;
import com.UTN.TP.Service.PatientService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.Objects;

@RestController
@RequestMapping("/patientController")
public class PatientController {

    private static final Log LOG = LogFactory.getLog(PatientController.class);

    @Autowired
    PatientService patientService;

    @Autowired
    DiseaseService diseaseService;

//    @Autowired
//    DoctorService doctorService;



    @GetMapping("/addPatient")
    public ModelAndView addPatient(){
        ModelAndView mav= new ModelAndView("addPatient");
        mav.addObject("patient", new PatientModel());
        return mav;
    }

    @PostMapping("/add")
    public RedirectView add(@ModelAttribute("patient")PatientModel patientModel){
        patientService.addPatient(patientModel);
        return new RedirectView("/patientController/findAll");
    }

    @GetMapping("/patient/{id}")
    public ModelAndView viewPatient(@PathVariable("id") String id){
        ModelAndView mav = new ModelAndView("profilePatient");
        mav.addObject("patient", patientService.findById(id));
        if (patientService.findById(id).getDisease() != null) {
            mav.addObject("incompleteTask",patientService.findIncompleteTaskById(id));
            mav.addObject("completeTask",patientService.findCompleteTaskById(id));
        }
        return mav;
    }

    @GetMapping("/patient/{id}/{idAction}")
    public RedirectView updateTask(@PathVariable(value = "id")String id,@PathVariable(value = "idAction")String idAction){
        PatientModel patient = patientService.findById(id);
        LOG.info("PATIENT ID : " + patient);

        patient.getDisease().getTreatment().getActionList().forEach(x->{
            if(Objects.equals(x.getIdAction(), idAction)){
                x.setDoIt(true);
            }
        });
        patientService.addPatient(patient);
        return new RedirectView("/patientController/patient/" + patient.getIdPatient());
    }


    @GetMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView("listPatient");
        modelAndView.addObject("listPatient", patientService.getPatientList());
        modelAndView.addObject("message","The doctor did not review your case");
        return modelAndView;
    }

    @GetMapping("/patient/{id}/delete")
    public RedirectView deletePatient(@PathVariable("id")String idPatient){
        patientService.deletePatient(idPatient);
        return new RedirectView("/patientController/");
    }

    @GetMapping("/")
    public ModelAndView error404(){
        ModelAndView mav = new ModelAndView("deletePatient");
        return mav;
    }



//    @PostMapping("/updateServe")
//    public RedirectView updateServePatient(@ModelAttribute("idPatient")String idPatient, @ModelAttribute("idDoctor")String idDoctor){
//        PatientModel patient = patientService.findById(idPatient);
//        patient.setServe(true);
//        return new RedirectView("/doctorController/doctor/{idDoctor}");
//    }


}
