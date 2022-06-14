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
    ///  0 0/5 * * * ? cada 5 min
    ///  */5 * * * * * cada 5 seg
    public void resetdoItTaksAndAddToIncompleteTask(){
        LOG.info("Traigo la lista del repo");
        List<PatientModel> patientModels = patientService.getPatientList();
        patientModels.forEach(x -> {
            x.getDisease().getTreatment().getActionList().forEach( y -> {
                if (!y.isDoIt()){
                    x.getIncompleteTaskList().add(y);
                }
                LOG.info("cambio el " + y.isDoIt() + " por false");
                y.setDoIt(false);
            });
            LOG.info("El patient a guardar es " + x);
            patientService.addPatient(x);
        });
        LOG.info("termino todo el ciclo");
    }



}
