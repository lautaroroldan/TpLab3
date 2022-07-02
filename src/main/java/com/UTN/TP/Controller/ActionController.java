package com.UTN.TP.Controller;


import com.UTN.TP.dto.ActionDTO;
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

    @PostMapping("/addActionJson")
    public void addActionJson(@RequestBody ActionDTO actionDTO){

        actionService.addAction(actionDTO);

    }

    @GetMapping("/findAllJson")
    public List<ActionDTO> findAllJson(){

        return actionService.getActionList();
    }

// ===========================================================================================


    @GetMapping("/addAction")
    ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView("addAction");
<<<<<<< HEAD
        modelAndView.addObject("action",new ActionDTO());

=======
        modelAndView.addObject("action",new ActionModel());
>>>>>>> 96235ac0df5e1f30a334c0082e404e3cf440a052
        return modelAndView;
    }

    @PostMapping("/add")
    public RedirectView addAction(@ModelAttribute("action") ActionDTO actionDTO){

        RedirectView redirectView = new RedirectView("/actionController/findAll");
        actionService.addAction(actionDTO);

        return redirectView;
    }



    @GetMapping("/findAll")
    public ModelAndView findAll(){

        ModelAndView modelAndView = new ModelAndView("listAction");
        modelAndView.addObject("listAction1", actionService.getActionList());

        return modelAndView;
    }

}
