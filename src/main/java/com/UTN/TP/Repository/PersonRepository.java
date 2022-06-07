package com.UTN.TP.Repository;

import com.UTN.TP.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("PersonJpaRepository")
public interface PersonRepository extends JpaRepository<Person, Serializable> {
}
