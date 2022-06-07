package com.UTN.TP.Repository;

import com.UTN.TP.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("PatientJpaRepository")
public interface PatientRepository extends JpaRepository<Patient, Serializable> {
}
