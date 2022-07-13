package com.UTN.TP.Config;


import com.UTN.TP.dto.PatientDTO;
import com.UTN.TP.service.PatientService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableScheduling
public class SchedulingConfig {
    @Autowired
    PatientService patientService;

    private final static Log LOG = LogFactory.getLog(SchedulingConfig.class);

    @Scheduled(cron = "  0 0/5 * * * ? ")
    public void scheduleUsingExpression(){
        LocalDateTime localDateTime = LocalDateTime.now();
        LOG.info("LOCAL TIME : "+localDateTime);
    }

    @Scheduled(cron = "@daily")
    ///  0 0/5 * * * ? cada 5 min
    ///  */5 * * * * * cada 5 seg
    public void resetdoItTaksAndAddToIncompleteTask(){
        LOG.info("Traigo la lista del repo");
        List<PatientDTO> patientDTOS = patientService.getPatientList();
//        LocalDate date = LocalDate.now();
        patientDTOS.forEach(x -> {
            if (x.getDisease()!=null){
                x.getDisease().getTreatment().getActionList().forEach( y -> {
                    if (!y.isDoIt()){
                        LOG.info("Entro al if METHOD y.isDoIt");
                        if (x.getIncompleteTaskList()==null){
                            LOG.info("Creo la lista IncompleteTask porque esta nula");
                            x.setIncompleteTaskList(new ArrayList<>());
                        }
                        x.getIncompleteTaskList().add(y);
//                    int index = x.getIncompleteTaskList().indexOf(y);
//                    x.getIncompleteTaskList().get(index).setInit(date);
                    }
                    LOG.info("cambio el " + y.isDoIt() + " por false");
                    y.setDoIt(false);
                });
            }
            LOG.info("El patient a guardar es " + x);
            patientService.addPatient(x);
        });
        LOG.info("termino todo el ciclo");
    }
}
