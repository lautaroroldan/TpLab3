package com.UTN.TP.controller;

import com.UTN.TP.dto.ActionDTO;
import com.UTN.TP.dto.TreatmentDTO;
import com.UTN.TP.service.ActionService;
import com.UTN.TP.service.TreatmentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/treatmentController")
public class TreatmentController {

    private static final Log log = LogFactory.getLog(TreatmentController.class);

    @Autowired
    TreatmentService treatmentService;

    @Autowired
    ActionService actionService;

    @PostMapping("/addJson")
    public void addTreatment(@RequestBody TreatmentDTO treatmentDTO){
        treatmentService.addTreatment(treatmentDTO);
    }

    @GetMapping("/addTreatment")
    public ModelAndView add(){
        ModelAndView mav = new ModelAndView("addTreatment");
        mav.addObject("treatment", new TreatmentDTO());
        mav.addObject("actionList", actionService.getActionList());
        mav.addObject("actionModel", new ActionDTO());
        return mav;
    }

    @PostMapping("/add")
    public RedirectView addTreatment(@ModelAttribute("treatment") TreatmentDTO treatmentDTO, @ModelAttribute("actionModel") ActionDTO actionDTO){
        RedirectView redirectView = new RedirectView("/treatmentController/findAll");
        ActionDTO actionDTO1 = actionService.findById(actionDTO.getIdAction());
        log.info(" El ID seleccionado es " + actionDTO.getIdAction());
        log.info("El actionModel buscado por id es : " + actionService.findById(actionDTO.getIdAction()));
        List<ActionDTO> actionDTOS = new ArrayList<>();
        actionDTOS.add(actionDTO1);
        treatmentDTO.setActionList(actionDTOS);
        treatmentService.addTreatment(treatmentDTO);
        return redirectView;
    }

    @GetMapping("/{id}")
    public ModelAndView updateTreatment(@PathVariable("id")String id){
        ModelAndView mav = new ModelAndView("addTreatment");
        mav.addObject("treatment",treatmentService.findById(id));
        mav.addObject("actionList", actionService.getActionList());
        mav.addObject("actionModel", new ActionDTO());
        return mav;
    }


    @GetMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView("listTreatment");
        modelAndView.addObject("listTreatment", treatmentService.getTreatmentList());
        return modelAndView;
    }
}
