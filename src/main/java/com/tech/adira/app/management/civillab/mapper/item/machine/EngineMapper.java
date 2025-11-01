package com.tech.adira.app.management.civillab.mapper.item.machine;

import com.tech.adira.app.management.civillab.common.AbstractAuditableMapper;
import com.tech.adira.app.management.civillab.model.dto.item.machine.EngineDto;
import com.tech.adira.app.management.civillab.model.entity.item.machine.EngineEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EngineMapper extends AbstractAuditableMapper<EngineEntity, EngineDto> {

    @Override
    public EngineDto toDto(EngineEntity entity) {
        if (entity == null) return null;

        EngineDto dto = new EngineDto();
        Optional.ofNullable(entity.getEngineType()).ifPresent(dto::setEngineType);
        Optional.ofNullable(entity.getEnginePower()).ifPresent(dto::setEnginePower);
        Optional.ofNullable(entity.getDescription()).ifPresent(dto::setDescription);
        mapAuditToDto(entity, dto);

        return dto;
    }

    @Override
    public EngineEntity toEntity(EngineDto dto) {
        if (dto == null) return null;

        EngineEntity entity = new EngineEntity();
        Optional.ofNullable(dto.getEngineType()).ifPresent(entity::setEngineType);
        Optional.ofNullable(dto.getEnginePower()).ifPresent(entity::setEnginePower);
        Optional.ofNullable(dto.getDescription()).ifPresent(entity::setDescription);
        mapAuditToEntity(dto, entity);

        return entity;
    }
}
