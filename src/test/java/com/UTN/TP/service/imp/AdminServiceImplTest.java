package com.UTN.TP.service.imp;

import com.UTN.TP.dto.AdminDTO;
import com.UTN.TP.service.AdminService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

class AdminServiceImplTest {

    @Mock
    AdminDTO adminModel;

    @Mock
    AdminService adminService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addAdmin() {
        adminModel = new AdminDTO("1");
        when(adminService.addAdmin(adminModel)).thenReturn(adminModel);
        Assertions.assertEquals(adminModel.getIdAdmin(),adminService.addAdmin(adminModel).getIdAdmin());
    }

    @Test
    void getAdminList() {
        List<AdminDTO> adminList = new ArrayList<>();
        adminList.add(adminModel);
        adminList.add(new AdminDTO("2"));
        when(adminService.getAdminList()).thenReturn(adminList);
        List<AdminDTO> adminModels = adminService.getAdminList();
        Assertions.assertEquals(2,adminModels.size());
    }
}