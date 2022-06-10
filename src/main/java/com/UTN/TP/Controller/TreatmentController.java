package com.UTN.TP.Controller;

import com.UTN.TP.Model.TreatmentModel;
import com.UTN.TP.Service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("treatmentController")
public class TreatmentController {

    @Autowired
    TreatmentService treatmentService;

    @PostMapping("addTreatment")
    public void addTreatment(@RequestBody TreatmentModel treatmentModel){
        treatmentService.addTreatment(treatmentModel);
    }

    @GetMapping("findAll")
    public List<TreatmentModel> findAll(){
        return treatmentService.getTreatmentList();
    }
}
