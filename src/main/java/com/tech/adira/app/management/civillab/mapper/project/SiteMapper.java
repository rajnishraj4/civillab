package com.tech.adira.app.management.civillab.mapper.project;

import com.tech.adira.app.management.civillab.common.AbstractAuditableMapper;
import com.tech.adira.app.management.civillab.model.dto.project.SiteDto;
import com.tech.adira.app.management.civillab.model.entity.project.SiteEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SiteMapper extends AbstractAuditableMapper<SiteEntity, SiteDto> {

    @Override
    public SiteDto toDto(SiteEntity entity) {
        if (entity == null) return null;

        SiteDto dto = new SiteDto();
        Optional.ofNullable(entity.getSiteName()).ifPresent(dto::setSiteName);
        Optional.ofNullable(entity.getLocation()).ifPresent(dto::setLocation);
        Optional.ofNullable(entity.getStatus()).ifPresent(dto::setStatus);
        Optional.ofNullable(entity.getDescription()).ifPresent(dto::setDescription);
        mapAuditToDto(entity, dto);

        return dto;
    }

    @Override
    public SiteEntity toEntity(SiteDto dto) {
        if (dto == null) return null;

        SiteEntity entity = new SiteEntity();
        Optional.ofNullable(dto.getSiteName()).ifPresent(entity::setSiteName);
        Optional.ofNullable(dto.getLocation()).ifPresent(entity::setLocation);
        Optional.ofNullable(dto.getStatus()).ifPresent(entity::setStatus);
        Optional.ofNullable(dto.getDescription()).ifPresent(entity::setDescription);
        mapAuditToEntity(dto, entity);

        return entity;
    }
}
