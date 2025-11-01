package com.tech.adira.app.management.civillab.mapper.payroll.wage;

import com.tech.adira.app.management.civillab.model.dto.payroll.wage.WageDeductionDto;
import com.tech.adira.app.management.civillab.model.entity.payroll.wage.WageDeductionEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WageDeductionMapper {

    private final WageSlipMapper wageSlipMapper;

    public WageDeductionMapper(WageSlipMapper wageSlipMapper) {
        this.wageSlipMapper = wageSlipMapper;
    }

    public WageDeductionDto toDto(WageDeductionEntity entity) {
        if (entity == null) {
            return null;
        }
        WageDeductionDto dto = new WageDeductionDto();
        Optional.ofNullable(entity.getWageSlip()).ifPresent(slip -> dto.setWageSlip(wageSlipMapper.toDto(slip)));
        dto.setLineSequence(entity.getLineSequence());
        dto.setDescription(entity.getDescription());
        dto.setAmount(entity.getAmount());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setLastModifiedBy(entity.getLastModifiedBy());
        dto.setLastModifiedDate(entity.getLastModifiedDate());
        return dto;
    }

    public WageDeductionEntity toEntity(WageDeductionDto dto) {
        if (dto == null) {
            return null;
        }
        WageDeductionEntity entity = new WageDeductionEntity();
        Optional.ofNullable(dto.getWageSlip()).ifPresent(slipDto -> entity.setWageSlip(wageSlipMapper.toEntity(slipDto)));
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