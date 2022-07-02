package com.UTN.TP.Service.Impl;

import com.UTN.TP.Model.AdminModel;
import com.UTN.TP.Service.AdminService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AdminServiceImplTest {

    @Mock
    AdminModel adminModel;

    @Mock
    AdminService adminService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addAdmin() {
        adminModel = new AdminModel("1");
        when(adminService.addAdmin(adminModel)).thenReturn(adminModel);
        Assertions.assertEquals(adminModel.getIdAdmin(),adminService.addAdmin(adminModel).getIdAdmin());
    }

    @Test
    void getAdminList() {
        List<AdminModel> adminList = new ArrayList<>();
        adminList.add(adminModel);
        adminList.add(new AdminModel("2"));
        when(adminService.getAdminList()).thenReturn(adminList);
        List<AdminModel> adminModels = adminService.getAdminList();
        Assertions.assertEquals(2,adminModels.size());
    }
}