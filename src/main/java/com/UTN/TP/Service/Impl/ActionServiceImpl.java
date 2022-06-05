package com.UTN.TP.Service.Impl;


import com.UTN.TP.Service.ActionService;
import org.springframework.stereotype.Service;

@Service("ActionServiceImpl")
public class ActionServiceImpl implements ActionService {

    public String drinkWater(){
        return "I drank water";
    }

    public String takePill(){
        return "I took a pill";
    }

    public String measureBloodPressure(){
        return "I measured my blood pressure";
    }

    public String takeTempeture(){
        return "I took my tempeture";
    }

}
