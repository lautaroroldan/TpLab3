package com.UTN.TP.mapper;

import com.UTN.TP.entity.Admin;
import com.UTN.TP.dto.AdminDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapper {
    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    Admin toEntity(AdminDTO adminDTO);
    AdminDTO toModel(Admin admin);
}
