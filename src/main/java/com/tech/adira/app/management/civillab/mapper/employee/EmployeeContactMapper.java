package com.tech.adira.app.management.civillab.mapper.employee;

import com.tech.adira.app.management.civillab.common.AbstractAuditableMapper;
import com.tech.adira.app.management.civillab.model.dto.employee.EmployeeContactDto;
import com.tech.adira.app.management.civillab.model.entity.employee.EmployeeContactEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeeContactMapper extends AbstractAuditableMapper<EmployeeContactEntity, EmployeeContactDto> {

    @Override
    public EmployeeContactDto toDto(EmployeeContactEntity entity) {
        if (entity == null) return null;

        EmployeeContactDto dto = new EmployeeContactDto();
        Optional.ofNullable(entity.getContactType()).ifPresent(dto::setContactType);
        Optional.ofNullable(entity.getContactDetail()).ifPresent(dto::setContactDetail);
        mapAuditToDto(entity, dto);

        return dto;
    }

    @Override
    public EmployeeContactEntity toEntity(EmployeeContactDto dto) {
        if (dto == null) return null;

        EmployeeContactEntity entity = new EmployeeContactEntity();
        Optional.ofNullable(dto.getContactType()).ifPresent(entity::setContactType);
        Optional.ofNullable(dto.getContactDetail()).ifPresent(entity::setContactDetail);
        mapAuditToEntity(dto, entity);

        return entity;
    }
}
