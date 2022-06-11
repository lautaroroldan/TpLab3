package com.UTN.TP.Controller;


import com.UTN.TP.Model.ActionModel;
import com.UTN.TP.Service.ActionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/actionController")
public class ActionController {

    private static final Log LOG = LogFactory.getLog(ActionController.class);

    @Autowired
    ActionService actionService;

    @Autowired
    NextSequenceService nextSequenceService;

    @PostMapping("/addActionJson")
    public void addActionJson(@RequestBody ActionModel actionModel){

        actionService.addAction(actionModel);

    }

    @GetMapping("/findAllJson")
    public List<ActionModel> findAllJson(){

        return actionService.getActionList();
    }

// ===========================================================================================


    @GetMapping("/addAction")
    ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView("addAction");
        modelAndView.addObject("action",new ActionModel());

        return modelAndView;
    }

    @PostMapping("/add")
    public RedirectView addAction(@ModelAttribute("action")ActionModel actionModel){

        RedirectView redirectView = new RedirectView("/actionController/findAll");
        actionService.addAction(actionModel);

        return redirectView;
    }



    @GetMapping("/findAll")
    public ModelAndView findAll(){

        ModelAndView modelAndView = new ModelAndView("listAction");
        modelAndView.addObject("listAction1", actionService.getActionList());

        return modelAndView;
    }

}
