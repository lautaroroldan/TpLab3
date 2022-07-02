package com.UTN.TP.Service;

import com.UTN.TP.dto.AdminModel;

import java.util.List;

public interface AdminService {
    AdminModel addAdmin(AdminModel adminModel);
    List<AdminModel> getAdminList();

}
