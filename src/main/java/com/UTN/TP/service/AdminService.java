package com.UTN.TP.service;

import com.UTN.TP.dto.AdminDTO;

import java.util.List;

public interface AdminService {
    AdminDTO addAdmin(AdminDTO adminDTO);
    List<AdminDTO> getAdminList();

}
