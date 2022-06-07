package com.UTN.TP.Repository;

import com.UTN.TP.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("DoctorJpaRepository")
public interface DoctorRepository extends JpaRepository<Doctor, Serializable> {
}
