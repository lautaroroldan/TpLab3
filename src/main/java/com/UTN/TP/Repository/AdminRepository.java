package com.UTN.TP.Repository;

import com.UTN.TP.Entity.Admin;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends MongoRepository<Admin,Long> {
}
