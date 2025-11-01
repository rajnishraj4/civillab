package com.tech.adira.app.management.civillab.mapper.item;

import com.tech.adira.app.management.civillab.common.AbstractAuditableMapper;
import com.tech.adira.app.management.civillab.model.dto.item.GeneralItemTypeDto;
import com.tech.adira.app.management.civillab.model.entity.item.GeneralItemTypeEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GeneralItemTypeMapper extends AbstractAuditableMapper<GeneralItemTypeEntity, GeneralItemTypeDto> {

    @Override
    public GeneralItemTypeDto toDto(GeneralItemTypeEntity entity) {
        if (entity == null) {
            return null;
        }
        GeneralItemTypeDto dto = new GeneralItemTypeDto();
        Optional.ofNullable(entity.getTypeName()).ifPresent(dto::setTypeName);
        Optional.ofNullable(entity.getDescription()).ifPresent(dto::setDescription);
        mapAuditToDto(entity, dto);
        return dto;
    }

    @Override
    public GeneralItemTypeEntity toEntity(GeneralItemTypeDto dto) {
        if (dto == null) {
            return null;
        }
        GeneralItemTypeEntity entity = new GeneralItemTypeEntity();
        Optional.ofNullable(dto.getTypeName()).ifPresent(entity::setTypeName);
        Optional.ofNullable(dto.getDescription()).ifPresent(entity::setDescription);
        mapAuditToEntity(dto, entity);
        return entity;
    }
}
