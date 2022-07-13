package com.UTN.TP.repository;

import com.UTN.TP.entity.Doctor;
import com.UTN.TP.Model.PatientModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String> {

}
