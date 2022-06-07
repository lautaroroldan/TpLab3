package com.UTN.TP.Repository;

import com.UTN.TP.Entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("TreatmentJpaRepository")
public interface TreatmentRepository extends JpaRepository<Treatment, Serializable> {
}
