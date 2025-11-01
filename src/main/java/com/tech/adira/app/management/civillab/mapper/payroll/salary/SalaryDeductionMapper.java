package com.tech.adira.app.management.civillab.mapper.payroll.salary;

import com.tech.adira.app.management.civillab.model.dto.payroll.salary.SalaryDeductionDto;
import com.tech.adira.app.management.civillab.model.entity.payroll.salary.SalaryDeductionEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SalaryDeductionMapper {

    private final SalarySlipMapper salarySlipMapper;

    public SalaryDeductionMapper(SalarySlipMapper salarySlipMapper) {
        this.salarySlipMapper = salarySlipMapper;
    }

    public SalaryDeductionDto toDto(SalaryDeductionEntity entity) {
        if (entity == null) {
            return null;
        }
        SalaryDeductionDto dto = new SalaryDeductionDto();
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

    public SalaryDeductionEntity toEntity(SalaryDeductionDto dto) {
        if (dto == null) {
            return null;
        }
        SalaryDeductionEntity entity = new SalaryDeductionEntity();
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