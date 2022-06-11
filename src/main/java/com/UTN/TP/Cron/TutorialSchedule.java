package com.UTN.TP.Cron;

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

    @Scheduled(cron = "  0 0/5 * * * ? ")
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

    @Scheduled(cron = "@daily")
    ///  0 0/5 * * * ? cada 5 min
    ///  */5 * * * * * cada 5 seg
    public void resetdoItTaks(){
        LOG.info("Traigo la lista del repo");
        List<PatientModel> patientModels = patientService.getPatientList();
        LOG.info(" la lista es " + patientModels);
        patientModels.forEach(x -> {
            x.getDisease().getTreatment().getActionList().forEach( y -> {
                LOG.info("cambio " + y.isDoIt() + "por false");
                y.setDoIt(false);
            });
            LOG.info("El patient a guardar es " + x);
            patientService.addPatient(x);
        });
        LOG.info("termino todo el ciclo");
    }



}
