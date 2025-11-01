package com.tech.adira.app.management.civillab.mapper.management;

import com.tech.adira.app.management.civillab.common.AbstractAuditableMapper;
import com.tech.adira.app.management.civillab.model.dto.management.RoleDto;
import com.tech.adira.app.management.civillab.model.entity.management.RoleEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoleMapper extends AbstractAuditableMapper<RoleEntity, RoleDto> {

    @Override
    public RoleDto toDto(RoleEntity entity) {
        if (entity == null) return null;

        RoleDto dto = new RoleDto();
        Optional.ofNullable(entity.getRoleName()).ifPresent(dto::setRoleName);
        mapAuditToDto(entity, dto);
        return dto;
    }

    @Override
    public RoleEntity toEntity(RoleDto dto) {
        if (dto == null) return null;

        RoleEntity entity = new RoleEntity();
        Optional.ofNullable(dto.getRoleName()).ifPresent(entity::setRoleName);
        mapAuditToEntity(dto, entity);
        return entity;
    }
}
