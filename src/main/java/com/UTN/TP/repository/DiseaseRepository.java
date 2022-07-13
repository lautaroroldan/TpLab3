package com.UTN.TP.repository;

import com.UTN.TP.entity.Disease;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepository extends MongoRepository<Disease, String> {
}
