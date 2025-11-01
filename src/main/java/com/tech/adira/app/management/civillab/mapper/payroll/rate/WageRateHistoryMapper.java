package com.tech.adira.app.management.civillab.mapper.payroll.rate;

import com.tech.adira.app.management.civillab.common.AbstractAuditableMapper;
import com.tech.adira.app.management.civillab.mapper.employee.EmployeeMapper;
import com.tech.adira.app.management.civillab.model.dto.payroll.rate.WageRateHistoryDto;
import com.tech.adira.app.management.civillab.model.entity.payroll.rate.WageRateHistoryEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WageRateHistoryMapper extends AbstractAuditableMapper<WageRateHistoryEntity, WageRateHistoryDto> {

    private final EmployeeMapper employeeMapper;

    public WageRateHistoryMapper(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public WageRateHistoryDto toDto(WageRateHistoryEntity entity) {
        if (entity == null) {
            return null;
        }
        WageRateHistoryDto dto = new WageRateHistoryDto();
        Optional.ofNullable(entity.getEmployee()).ifPresent(e -> dto.setEmployee(employeeMapper.toDto(e)));
        Optional.ofNullable(entity.getHourlyRate()).ifPresent(dto::setHourlyRate);
        Optional.ofNullable(entity.getEffectiveFromDate()).ifPresent(dto::setEffectiveFromDate);
        Optional.ofNullable(entity.getEffectiveToDate()).ifPresent(dto::setEffectiveToDate);
        mapAuditToDto(entity, dto);
        return dto;
    }

    @Override
    public WageRateHistoryEntity toEntity(WageRateHistoryDto dto) {
        if (dto == null) {
            return null;
        }
        WageRateHistoryEntity entity = new WageRateHistoryEntity();
        Optional.ofNullable(dto.getEmployee()).ifPresent(e -> entity.setEmployee(employeeMapper.toEntity(e)));
        Optional.ofNullable(dto.getHourlyRate()).ifPresent(entity::setHourlyRate);
        Optional.ofNullable(dto.getEffectiveFromDate()).ifPresent(entity::setEffectiveFromDate);
        Optional.ofNullable(dto.getEffectiveToDate()).ifPresent(entity::setEffectiveToDate);
        mapAuditToEntity(dto, entity);
        return entity;
    }
}
