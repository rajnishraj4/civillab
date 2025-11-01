package com.tech.adira.app.management.civillab.mapper.employee;

import com.tech.adira.app.management.civillab.common.AbstractAuditableMapper;
import com.tech.adira.app.management.civillab.model.dto.employee.EmployeeAddressDto;
import com.tech.adira.app.management.civillab.model.entity.employee.EmployeeAddressEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeeAddressMapper extends AbstractAuditableMapper<EmployeeAddressEntity, EmployeeAddressDto> {

    @Override
    public EmployeeAddressDto toDto(EmployeeAddressEntity entity) {
        if (entity == null) return null;

        EmployeeAddressDto dto = new EmployeeAddressDto();
        Optional.ofNullable(entity.getStreetAddress()).ifPresent(dto::setStreetAddress);
        Optional.ofNullable(entity.getCity()).ifPresent(dto::setCity);
        Optional.ofNullable(entity.getState()).ifPresent(dto::setState);
        Optional.ofNullable(entity.getPostalCode()).ifPresent(dto::setPostalCode);
        Optional.ofNullable(entity.getCountry()).ifPresent(dto::setCountry);
        mapAuditToDto(entity, dto);

        return dto;
    }

    @Override
    public EmployeeAddressEntity toEntity(EmployeeAddressDto dto) {
        if (dto == null) return null;

        EmployeeAddressEntity entity = new EmployeeAddressEntity();
        Optional.ofNullable(dto.getStreetAddress()).ifPresent(entity::setStreetAddress);
        Optional.ofNullable(dto.getCity()).ifPresent(entity::setCity);
        Optional.ofNullable(dto.getState()).ifPresent(entity::setState);
        Optional.ofNullable(dto.getPostalCode()).ifPresent(entity::setPostalCode);
        Optional.ofNullable(dto.getCountry()).ifPresent(entity::setCountry);
        mapAuditToEntity(dto, entity);

        return entity;
    }
}
