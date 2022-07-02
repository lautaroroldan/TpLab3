package com.UTN.TP.Repository;

import com.UTN.TP.Entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
    List<Patient> findAllByServe(boolean choice);
    Patient findByDni(long dni);
}
