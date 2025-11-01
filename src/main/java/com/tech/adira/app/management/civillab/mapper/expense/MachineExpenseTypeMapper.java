package com.tech.adira.app.management.civillab.mapper.expense;

import com.tech.adira.app.management.civillab.common.AbstractAuditableMapper;
import com.tech.adira.app.management.civillab.model.dto.expense.MachineExpenseTypeDto;
import com.tech.adira.app.management.civillab.model.entity.expense.MachineExpenseTypeEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MachineExpenseTypeMapper extends AbstractAuditableMapper<MachineExpenseTypeEntity, MachineExpenseTypeDto> {

    @Override
    public MachineExpenseTypeDto toDto(MachineExpenseTypeEntity entity) {
        if (entity == null) {
            return null;
        }
        MachineExpenseTypeDto dto = new MachineExpenseTypeDto();
        Optional.ofNullable(entity.getTypeName()).ifPresent(dto::setTypeName);
        Optional.ofNullable(entity.getCategory()).ifPresent(dto::setCategory);
        mapAuditToDto(entity, dto);
        return dto;
    }

    @Override
    public MachineExpenseTypeEntity toEntity(MachineExpenseTypeDto dto) {
        if (dto == null) {
            return null;
        }
        MachineExpenseTypeEntity entity = new MachineExpenseTypeEntity();
        Optional.ofNullable(dto.getTypeName()).ifPresent(entity::setTypeName);
        Optional.ofNullable(dto.getCategory()).ifPresent(entity::setCategory);
        mapAuditToEntity(dto, entity);
        return entity;
    }
}

