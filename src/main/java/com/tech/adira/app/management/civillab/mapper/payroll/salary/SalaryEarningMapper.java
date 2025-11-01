package com.tech.adira.app.management.civillab.mapper.payroll.salary;

import com.tech.adira.app.management.civillab.mapper.employee.EmployeeMapper;
import com.tech.adira.app.management.civillab.model.dto.payroll.salary.SalaryEarningDto;
import com.tech.adira.app.management.civillab.model.entity.payroll.salary.SalaryEarningEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SalaryEarningMapper {

    private final EmployeeMapper employeeMapper;
    private final SalarySlipMapper salarySlipMapper;

    public SalaryEarningMapper(EmployeeMapper employeeMapper, SalarySlipMapper salarySlipMapper) {
        this.employeeMapper = employeeMapper;
        this.salarySlipMapper = salarySlipMapper;
    }

    public SalaryEarningDto toDto(SalaryEarningEntity entity) {
        if (entity == null) {
            return null;
        }
        SalaryEarningDto dto = new SalaryEarningDto();
        Optional.ofNullable(entity.getSalarySlip()).ifPresent(slip -> dto.setSalarySlip(salarySlipMapper.toDto(slip)));
        dto.setLineSequence(entity.getLineSequence());
        dto.setDescription(entity.getDescription());
        dto.setAmount(entity.getAmount());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setLastModifiedBy(entity.getLastModifiedBy());
        dto.setLastModifiedDate(entity.getLastModifiedDate());
        return dto;
    }

    public SalaryEarningEntity toEntity(SalaryEarningDto dto) {
        if (dto == null) {
            return null;
        }
        SalaryEarningEntity entity = new SalaryEarningEntity();
        Optional.ofNullable(dto.getSalarySlip()).ifPresent(slipDto -> entity.setSalarySlip(salarySlipMapper.toEntity(slipDto)));
        entity.setLineSequence(dto.getLineSequence());
        entity.setDescription(dto.getDescription());
        entity.setAmount(dto.getAmount());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setLastModifiedBy(dto.getLastModifiedBy());
        entity.setLastModifiedDate(dto.getLastModifiedDate());
        return entity;
    }
}
