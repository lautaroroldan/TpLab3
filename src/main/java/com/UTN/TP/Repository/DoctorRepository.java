package com.UTN.TP.Repository;

import com.UTN.TP.Entity.Doctor;
import com.UTN.TP.Entity.Patient;
import com.UTN.TP.Model.PatientModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String> {

}
