package com.UTN.TP.repository;

import com.UTN.TP.entity.Action;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActionRepository  extends MongoRepository<Action,String> {

}
