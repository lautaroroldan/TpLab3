package com.UTN.TP.Repository;

import com.UTN.TP.Entity.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("ActionJpaRepository")
public interface ActionRepository extends JpaRepository<Action, Serializable> {
}
