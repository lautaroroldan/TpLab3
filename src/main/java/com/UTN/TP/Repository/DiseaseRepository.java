package com.UTN.TP.Repository;

import com.UTN.TP.Entity.Disease;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface DiseaseRepository extends MongoRepository<Disease, Long> {
}
