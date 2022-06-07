package com.UTN.TP.Repository;

import com.UTN.TP.Entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("DiseaseJpaRepository")
public interface DiseaseRepository extends JpaRepository<Disease, Serializable> {
}
