package com.tech.adira.app.management.civillab.mapper.payroll.wage;

import com.tech.adira.app.management.civillab.common.AbstractAuditableMapper;
import com.tech.adira.app.management.civillab.mapper.employee.EmployeeMapper;
import com.tech.adira.app.management.civillab.model.dto.payroll.wage.WageSlipDto;
import com.tech.adira.app.management.civillab.model.entity.payroll.wage.WageSlipEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WageSlipMapper extends AbstractAuditableMapper<WageSlipEntity, WageSlipDto> {

    private final EmployeeMapper employeeMapper;

    public WageSlipMapper(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public WageSlipDto toDto(WageSlipEntity entity) {
        if (entity == null) {
            return null;
        }
        WageSlipDto dto = new WageSlipDto();
        Optional.ofNullable(entity.getEmployee()).ifPresent(e -> dto.setEmployee(employeeMapper.toDto(e)));
        Optional.ofNullable(entity.getPayPeriodStart()).ifPresent(dto::setPayPeriodStart);
        Optional.ofNullable(entity.getPayPeriodEnd()).ifPresent(dto::setPayPeriodEnd);
        Optional.ofNullable(entity.getSlipDate()).ifPresent(dto::setSlipDate);
        Optional.ofNullable(entity.getTotalEarnings()).ifPresent(dto::setTotalEarnings);
        Optional.ofNullable(entity.getTotalDeductions()).ifPresent(dto::setTotalDeductions);
        Optional.ofNullable(entity.getNetPayable()).ifPresent(dto::setNetPayable);
        mapAuditToDto(entity, dto);
        return dto;
    }

    @Override
    public WageSlipEntity toEntity(WageSlipDto dto) {
        if (dto == null) {
            return null;
        }
        WageSlipEntity entity = new WageSlipEntity();
        Optional.ofNullable(dto.getEmployee()).ifPresent(e -> entity.setEmployee(employeeMapper.toEntity(e)));
        Optional.ofNullable(dto.getPayPeriodStart()).ifPresent(entity::setPayPeriodStart);
        Optional.ofNullable(dto.getPayPeriodEnd()).ifPresent(entity::setPayPeriodEnd);
        Optional.ofNullable(dto.getSlipDate()).ifPresent(entity::setSlipDate);
        Optional.ofNullable(dto.getTotalEarnings()).ifPresent(entity::setTotalEarnings);
        Optional.ofNullable(dto.getTotalDeductions()).ifPresent(entity::setTotalDeductions);
        Optional.ofNullable(dto.getNetPayable()).ifPresent(entity::setNetPayable);
        mapAuditToEntity(dto, entity);
        return entity;
    }
}