package com.tech.adira.app.management.civillab.mapper.item;

import com.tech.adira.app.management.civillab.common.AbstractAuditableMapper;
import com.tech.adira.app.management.civillab.model.dto.item.GeneralItemDto;
import com.tech.adira.app.management.civillab.model.entity.item.GeneralItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeneralItemMapper extends AbstractAuditableMapper<GeneralItemEntity, GeneralItemDto> {

    private final GeneralItemTypeMapper generalItemTypeMapper;

    @Autowired
    public GeneralItemMapper(GeneralItemTypeMapper generalItemTypeMapper) {
        this.generalItemTypeMapper = generalItemTypeMapper;
    }

    @Override
    public GeneralItemDto toDto(GeneralItemEntity entity) {
        if (entity == null) {
            return null;
        }
        GeneralItemDto dto = new GeneralItemDto();
        dto.setTypeName(entity.getTypeName());
        dto.setDescription(entity.getDescription());
        if (entity.getGeneralItemType() != null) {
            dto.setGeneralItemType(generalItemTypeMapper.toDto(entity.getGeneralItemType()));
        }
        mapAuditToDto(entity, dto);
        return dto;
    }

    @Override
    public GeneralItemEntity toEntity(GeneralItemDto dto) {
        if (dto == null) {
            return null;
        }
        GeneralItemEntity entity = new GeneralItemEntity();
        entity.setTypeName(dto.getTypeName());
        entity.setDescription(dto.getDescription());
        if (dto.getGeneralItemType() != null) {
            entity.setGeneralItemType(generalItemTypeMapper.toEntity(dto.getGeneralItemType()));
        }
        mapAuditToEntity(dto, entity);
        return entity;
    }
}
