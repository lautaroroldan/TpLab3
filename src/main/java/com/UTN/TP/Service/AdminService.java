package com.UTN.TP.Service;

import com.UTN.TP.Model.AdminModel;

import java.util.List;

public interface AdminService {
    AdminModel addAdmin(AdminModel adminModel);
    List<AdminModel> getAdminList();
}
