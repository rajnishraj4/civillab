package com.tech.adira.app.management.civillab.mapper.payroll.salary;

import com.tech.adira.app.management.civillab.common.AbstractAuditableMapper;
import com.tech.adira.app.management.civillab.mapper.employee.EmployeeMapper;
import com.tech.adira.app.management.civillab.model.dto.payroll.salary.SalarySlipDto;
import com.tech.adira.app.management.civillab.model.entity.payroll.salary.SalarySlipEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SalarySlipMapper extends AbstractAuditableMapper<SalarySlipEntity, SalarySlipDto> {

    private final EmployeeMapper employeeMapper;

    public SalarySlipMapper(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public SalarySlipDto toDto(SalarySlipEntity entity) {
        if (entity == null) {
            return null;
        }
        SalarySlipDto dto = new SalarySlipDto();
        Optional.ofNullable(entity.getEmployee()).ifPresent(e -> dto.setEmployee(employeeMapper.toDto(e)));
        Optional.ofNullable(entity.getPayPeriodStart()).ifPresent(dto::setPayPeriodStart);
        Optional.ofNullable(entity.getPayPeriodEnd()).ifPresent(dto::setPayPeriodEnd);
        Optional.ofNullable(entity.getSlipDate()).ifPresent(dto::setSlipDate);
        Optional.ofNullable(entity.getGrossSalary()).ifPresent(dto::setGrossSalary);
        Optional.ofNullable(entity.getTotalEarnings()).ifPresent(dto::setTotalEarnings);
        Optional.ofNullable(entity.getTotalDeductions()).ifPresent(dto::setTotalDeductions);
        Optional.ofNullable(entity.getNetPayable()).ifPresent(dto::setNetPayable);
        mapAuditToDto(entity, dto);
        return dto;
    }

    @Override
    public SalarySlipEntity toEntity(SalarySlipDto dto) {
        if (dto == null) {
            return null;
        }
        SalarySlipEntity entity = new SalarySlipEntity();
        Optional.ofNullable(dto.getEmployee()).ifPresent(e -> entity.setEmployee(employeeMapper.toEntity(e)));
        Optional.ofNullable(dto.getPayPeriodStart()).ifPresent(entity::setPayPeriodStart);
        Optional.ofNullable(dto.getPayPeriodEnd()).ifPresent(entity::setPayPeriodEnd);
        Optional.ofNullable(dto.getSlipDate()).ifPresent(entity::setSlipDate);
        Optional.ofNullable(dto.getGrossSalary()).ifPresent(entity::setGrossSalary);
        Optional.ofNullable(dto.getTotalEarnings()).ifPresent(entity::setTotalEarnings);
        Optional.ofNullable(dto.getTotalDeductions()).ifPresent(entity::setTotalDeductions);
        Optional.ofNullable(dto.getNetPayable()).ifPresent(entity::setNetPayable);
        mapAuditToEntity(dto, entity);
        return entity;
    }
}
