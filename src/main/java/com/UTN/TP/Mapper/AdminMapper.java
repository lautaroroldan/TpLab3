package com.UTN.TP.Mapper;

import com.UTN.TP.Entity.Admin;
import com.UTN.TP.Model.AdminModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapper {
    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    Admin toEntity(AdminModel adminModel);
    AdminModel toModel(Admin admin);
}
