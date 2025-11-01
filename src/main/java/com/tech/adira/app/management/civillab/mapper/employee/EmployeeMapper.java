package com.tech.adira.app.management.civillab.mapper.employee;

import com.tech.adira.app.management.civillab.common.AbstractAuditableMapper;
import com.tech.adira.app.management.civillab.model.dto.employee.EmployeeDto;
import com.tech.adira.app.management.civillab.model.entity.employee.EmployeeEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class EmployeeMapper extends AbstractAuditableMapper<EmployeeEntity, EmployeeDto> {

    @Override
    public EmployeeDto toDto(EmployeeEntity entity) {
        if (entity == null) return null;

        EmployeeDto dto = new EmployeeDto();
        Optional.ofNullable(entity.getFirstName()).ifPresent(dto::setFirstName);
        Optional.ofNullable(entity.getLastName()).ifPresent(dto::setLastName);
        Optional.ofNullable(entity.getAadhaarNumber()).ifPresent(dto::setAadhaarNumber);
        Optional.ofNullable(entity.getDateOfBirth())
                .map(LocalDate::toString)
                .ifPresent(dto::setDateOfBirth);
        Optional.ofNullable(entity.getGender()).ifPresent(dto::setGender);
        dto.setVerified(entity.isVerified());
        Optional.ofNullable(entity.getEmployeeType()).ifPresent(dto::setEmployeeType);

        mapAuditToDto(entity, dto);

        return dto;
    }

    @Override
    public EmployeeEntity toEntity(EmployeeDto dto) {
        if (dto == null) return null;

        EmployeeEntity entity = new EmployeeEntity();
        Optional.ofNullable(dto.getFirstName()).ifPresent(entity::setFirstName);
        Optional.ofNullable(dto.getLastName()).ifPresent(entity::setLastName);
        Optional.ofNullable(dto.getAadhaarNumber()).ifPresent(entity::setAadhaarNumber);
        Optional.ofNullable(dto.getDateOfBirth())
                .filter(dateStr -> !dateStr.isBlank())
                .map(LocalDate::parse)
                .ifPresent(entity::setDateOfBirth);
        Optional.ofNullable(dto.getGender()).ifPresent(entity::setGender);
        Optional.ofNullable(dto.getEmployeeType()).ifPresent(entity::setEmployeeType);

        entity.setVerified(dto.isVerified());

        mapAuditToEntity(dto, entity);

        return entity;
    }
}
