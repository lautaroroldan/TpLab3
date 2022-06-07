package com.UTN.TP.Repository;

import com.UTN.TP.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("AdminJpaRepository")
public interface AdminRepository extends JpaRepository<Admin, Serializable> {
}
