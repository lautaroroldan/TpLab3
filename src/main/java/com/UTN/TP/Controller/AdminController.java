package com.UTN.TP.Controller;

import com.UTN.TP.Model.AdminModel;
import com.UTN.TP.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@RestController
@RequestMapping("/adminController")
public class AdminController {

    @Autowired
    AdminService adminService;




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

}
