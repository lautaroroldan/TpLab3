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
import java.util.Objects;

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
        LOG.info("ID TREATMENT : " + treatmentModel.getIdTreatment());
        ActionModel action = actionService.findById(actionModel.getIdAction());
        LOG.info("ID ACTION SELECT : " + action.getIdAction());

        if (treatmentModel.getIdTreatment()==null){
            List<ActionModel> actionModels = new ArrayList<>();
            actionModels.add(action);
            treatmentModel.setActionList(actionModels);
        }else{
            TreatmentModel treatmentModel1 = treatmentService.findById(treatmentModel.getIdTreatment());
            treatmentModel1.getActionList().add(action);
            treatmentModel.setActionList(treatmentModel1.getActionList());
        }
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
