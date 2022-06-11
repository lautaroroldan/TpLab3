package com.UTN.TP.Controller;

import com.UTN.TP.Model.ActionModel;
import com.UTN.TP.Model.TreatmentModel;
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

@RestController
@RequestMapping("/treatmentController")
public class TreatmentController {

    @PostMapping("/addJson")
    public void addTreatment(@RequestBody TreatmentModel treatmentModel){
        treatmentService.addTreatment(treatmentModel);
    }

    private static final Log LOG = LogFactory.getLog(TreatmentController.class);

    @Autowired
    TreatmentService treatmentService;

    @Autowired
    ActionService actionService;

    @Autowired
    NextSequenceService nextSequenceService;

    @GetMapping("/addTreatment")
    public ModelAndView add(){
        ModelAndView mav = new ModelAndView("addTreatment");
        mav.addObject("treatment", new TreatmentModel());
        mav.addObject("actionList", actionService.getActionList());
        mav.addObject("actionModel", new ActionModel());
        return mav;
    }

    @PostMapping("/add")
    public RedirectView addTreatment(@ModelAttribute("treatment") TreatmentModel treatmentModel, @ModelAttribute("actionModel") ActionModel actionModel){
        RedirectView redirectView = new RedirectView("/treatmentController/findAll");

        ActionModel actionModel1 = actionService.findById(actionModel.getId());

        LOG.info(" El ID seleccionado es " + actionModel.getId());
        LOG.info("El actionModel buscado por id es : " + actionService.findById(actionModel.getId()));

        List<ActionModel> actionModels = new ArrayList<>();
        actionModels.add(actionModel1);

        treatmentModel.setActionList(actionModels);
        treatmentService.addTreatment(treatmentModel);
        return redirectView;
    }



    @GetMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView("listTreatment");
        modelAndView.addObject("listTreatment", treatmentService.getTreatmentList());
        return modelAndView;
    }
}
