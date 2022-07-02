package com.UTN.TP.Controller;

import com.UTN.TP.dto.ActionDTO;
import com.UTN.TP.dto.TreatmentModel;
import com.UTN.TP.Service.ActionService;
import com.UTN.TP.Service.TreatmentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/treatmentController")
public class TreatmentController {

    private static final Log log = LogFactory.getLog(TreatmentController.class);

    @Autowired
    TreatmentService treatmentService;

    @Autowired
    ActionService actionService;

    @PostMapping("/addJson")
    public void addTreatment(@RequestBody TreatmentModel treatmentModel){
        treatmentService.addTreatment(treatmentModel);
    }

    @GetMapping("/addTreatment")
    public ModelAndView add(){
        ModelAndView mav = new ModelAndView("addTreatment");
        mav.addObject("treatment", new TreatmentModel());
        mav.addObject("actionList", actionService.getActionList());
        mav.addObject("actionModel", new ActionDTO());
        return mav;
    }

    @PostMapping("/add")
    public RedirectView addTreatment(@ModelAttribute("treatment") TreatmentModel treatmentModel, @ModelAttribute("actionModel") ActionDTO actionDTO){
        RedirectView redirectView = new RedirectView("/treatmentController/findAll");
        LOG.info("ID TREATMENT : " + treatmentModel.getIdTreatment());
        ActionModel action = actionService.findById(actionModel.getIdAction());
        LOG.info("ID ACTION SELECT : " + action.getIdAction());

<<<<<<< HEAD
        ActionDTO actionDTO1 = actionService.findById(actionDTO.getIdAction());

        log.info(" El ID seleccionado es " + actionDTO.getIdAction());
        log.info("El actionModel buscado por id es : " + actionService.findById(actionDTO.getIdAction()));

        List<ActionDTO> actionDTOS = new ArrayList<>();
        actionDTOS.add(actionDTO1);

        treatmentModel.setActionList(actionDTOS);
=======
        if (treatmentModel.getIdTreatment()==null){
            List<ActionModel> actionModels = new ArrayList<>();
            actionModels.add(action);
            treatmentModel.setActionList(actionModels);
        }else{
            TreatmentModel treatmentModel1 = treatmentService.findById(treatmentModel.getIdTreatment());
            treatmentModel1.getActionList().add(action);
            treatmentModel.setActionList(treatmentModel1.getActionList());
        }
>>>>>>> 96235ac0df5e1f30a334c0082e404e3cf440a052
        treatmentService.addTreatment(treatmentModel);
        return redirectView;
    }

    @GetMapping("/{id}")
    public ModelAndView updateTreatment(@PathVariable("id")String id){
        ModelAndView mav = new ModelAndView("addTreatment");
        mav.addObject("treatment",treatmentService.findById(id));
        mav.addObject("actionList", actionService.getActionList());
        mav.addObject("actionModel", new ActionModel());
        return mav;
    }


    @GetMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView("listTreatment");
        modelAndView.addObject("listTreatment", treatmentService.getTreatmentList());
        return modelAndView;
    }
}
