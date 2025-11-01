package com.tech.adira.app.management.civillab.mapper.item.machine;

import com.tech.adira.app.management.civillab.common.AbstractAuditableMapper;
import com.tech.adira.app.management.civillab.model.dto.item.machine.EquipmentDto;
import com.tech.adira.app.management.civillab.model.entity.item.machine.EquipmentEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EquipmentMapper extends AbstractAuditableMapper<EquipmentEntity, EquipmentDto> {

    private final EngineMapper engineMapper;

    public EquipmentMapper(EngineMapper engineMapper) {
        this.engineMapper = engineMapper;
    }

    @Override
    public EquipmentDto toDto(EquipmentEntity entity) {
        if (entity == null) {
            return null;
        }
        EquipmentDto dto = new EquipmentDto();
        Optional.ofNullable(entity.getEquipmentName()).ifPresent(dto::setEquipmentName);
        Optional.ofNullable(entity.getOwnership()).ifPresent(dto::setOwnership);
        Optional.ofNullable(entity.getOwnerName()).ifPresent(dto::setOwnerName);

        if (entity.getEngine() != null) {
            dto.setEngine(engineMapper.toDto(entity.getEngine()));
        }

        mapAuditToDto(entity, dto);
        return dto;
    }

    @Override
    public EquipmentEntity toEntity(EquipmentDto dto) {
        if (dto == null) {
            return null;
        }
        EquipmentEntity entity = new EquipmentEntity();
        Optional.ofNullable(dto.getEquipmentName()).ifPresent(entity::setEquipmentName);
        Optional.ofNullable(dto.getOwnership()).ifPresent(entity::setOwnership);
        Optional.ofNullable(dto.getOwnerName()).ifPresent(entity::setOwnerName);

        if (dto.getEngine() != null) {
            entity.setEngine(engineMapper.toEntity(dto.getEngine()));
        }

        mapAuditToEntity(dto, entity);
        return entity;
    }
}

