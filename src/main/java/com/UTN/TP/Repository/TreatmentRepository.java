package com.UTN.TP.Repository;

import com.UTN.TP.Entity.Treatment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TreatmentRepository extends MongoRepository<Treatment,String > {
}
