package com.UTN.TP.Cron;

import com.UTN.TP.Entity.Patient;
import com.UTN.TP.GlobalVariant.LocalDate;
import com.UTN.TP.Model.ActionModel;
import com.UTN.TP.Model.PatientModel;
import com.UTN.TP.Service.PatientService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class TutorialSchedule {

    @Autowired
    PatientService patientService;

    private final static Log LOG = LogFactory.getLog(TutorialSchedule.class);

    @Scheduled(cron = " * * * * * * ")
    public void scheduleUsingExpression(){
        LocalDateTime localDateTime = LocalDateTime.now();
        LOG.info(localDateTime);
    }

    @Scheduled(cron = "@daily")
    public void checkingTask(){
        List<PatientModel> patientModels = patientService.getPatientList();
        for (PatientModel patientModel : patientModels){
            List<ActionModel> actionModels = patientModel.getDisease().getTreatment().getActionList();
            int size = actionModels.size();
            if (actionModels.get(size).isDoIt() == false){
                List<ActionModel> incompleteTask = patientModel.getIncompleteTaskList();
                incompleteTask.add(actionModels.get(size));
            }
        }
    }



}
