package com.tech.adira.app.management.civillab.mapper.payroll.wage;

import com.tech.adira.app.management.civillab.model.dto.payroll.wage.WageEarningDto;
import com.tech.adira.app.management.civillab.model.entity.payroll.wage.WageEarningEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WageEarningMapper {

    private final WageSlipMapper wageSlipMapper;

    public WageEarningMapper(WageSlipMapper wageSlipMapper) {
        this.wageSlipMapper = wageSlipMapper;
    }

    public WageEarningDto toDto(WageEarningEntity entity) {
        if (entity == null) {
            return null;
        }
        WageEarningDto dto = new WageEarningDto();
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

    public WageEarningEntity toEntity(WageEarningDto dto) {
        if (dto == null) {
            return null;
        }
        WageEarningEntity entity = new WageEarningEntity();
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