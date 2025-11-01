package com.tech.adira.app.management.civillab.mapper.payroll.rate;

import com.tech.adira.app.management.civillab.common.AbstractAuditableMapper;
import com.tech.adira.app.management.civillab.mapper.employee.EmployeeMapper;
import com.tech.adira.app.management.civillab.model.dto.payroll.rate.SalaryRateHistoryDto;
import com.tech.adira.app.management.civillab.model.entity.payroll.rate.SalaryRateHistoryEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SalaryRateHistoryMapper extends AbstractAuditableMapper<SalaryRateHistoryEntity, SalaryRateHistoryDto> {

    private final EmployeeMapper employeeMapper;

    public SalaryRateHistoryMapper(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public SalaryRateHistoryDto toDto(SalaryRateHistoryEntity entity) {
        if (entity == null) {
            return null;
        }
        SalaryRateHistoryDto dto = new SalaryRateHistoryDto();
        Optional.ofNullable(entity.getEmployee()).ifPresent(e -> dto.setEmployee(employeeMapper.toDto(e)));
        Optional.ofNullable(entity.getBasicSalary()).ifPresent(dto::setBasicSalary);
        Optional.ofNullable(entity.getEffectiveFromDate()).ifPresent(dto::setEffectiveFromDate);
        Optional.ofNullable(entity.getEffectiveToDate()).ifPresent(dto::setEffectiveToDate);
        mapAuditToDto(entity, dto);
        return dto;
    }

    @Override
    public SalaryRateHistoryEntity toEntity(SalaryRateHistoryDto dto) {
        if (dto == null) {
            return null;
        }
        SalaryRateHistoryEntity entity = new SalaryRateHistoryEntity();
        Optional.ofNullable(dto.getEmployee()).ifPresent(e -> entity.setEmployee(employeeMapper.toEntity(e)));
        Optional.ofNullable(dto.getBasicSalary()).ifPresent(entity::setBasicSalary);
        Optional.ofNullable(dto.getEffectiveFromDate()).ifPresent(entity::setEffectiveFromDate);
        Optional.ofNullable(dto.getEffectiveToDate()).ifPresent(entity::setEffectiveToDate);
        mapAuditToEntity(dto, entity);
        return entity;
    }
}