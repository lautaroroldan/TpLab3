package com.UTN.TP.repository;

import com.UTN.TP.entity.Treatment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TreatmentRepository extends MongoRepository<Treatment,String > {
}
