package com.UTN.TP.Service.Impl;

import com.UTN.TP.Entity.Admin;
import com.UTN.TP.Mapper.AdminMapper;
import com.UTN.TP.Model.AdminModel;
import com.UTN.TP.Repository.AdminRepository;
import com.UTN.TP.Service.AdminService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("AdminServiceImpl")
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    @Override
    public AdminModel addAdmin(AdminModel adminModel) {
        adminRepository.save(INSTANCE.toEntity(adminModel));
        return adminModel;
    }

    @Override
    public List<AdminModel> getAdminList() {
        List<Admin> admins = adminRepository.findAll();
        List<AdminModel> adminModels= new ArrayList<>();
        admins.forEach(x-> adminModels.add(INSTANCE.toModel(x)));
        return adminModels;
    }
}
