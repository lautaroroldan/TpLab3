package com.UTN.TP.repository;

import com.UTN.TP.entity.Admin;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends MongoRepository<Admin,String> {
}
