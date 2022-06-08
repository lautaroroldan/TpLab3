package com.UTN.TP.Repository;

import com.UTN.TP.Entity.Action;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActionRepository  extends MongoRepository<Action,Long> {
}
