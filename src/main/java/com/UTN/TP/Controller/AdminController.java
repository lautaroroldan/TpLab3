package com.UTN.TP.Controller;

import com.UTN.TP.Model.ActionModel;
import com.UTN.TP.Model.AdminModel;
import com.UTN.TP.Service.ActionService;
import com.UTN.TP.Service.AdminService;
import com.UTN.TP.Service.NextSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@RestController
@RequestMapping("/adminController")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    NextSequenceService nextSequenceService;


    @GetMapping("/addAdmin")
    ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView("addAdmin");
        modelAndView.addObject("admin",new AdminModel());

        return modelAndView;
    }

    @PostMapping("/add")
    public RedirectView addAdmin(@ModelAttribute("admin") AdminModel adminModel){


        adminModel.setAdminId(nextSequenceService.getNextSequenceAdmin("customSequence"));


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

}
