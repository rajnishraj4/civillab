package com.tech.adira.app.management.civillab.mapper.project;

import com.tech.adira.app.management.civillab.common.AbstractAuditableMapper;
import com.tech.adira.app.management.civillab.model.dto.project.ProjectDto;
import com.tech.adira.app.management.civillab.model.entity.project.ProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper extends AbstractAuditableMapper<ProjectEntity, ProjectDto> {

    private final SiteMapper siteMapper;

    @Autowired
    public ProjectMapper(SiteMapper siteMapper) {
        this.siteMapper = siteMapper;
    }

    @Override
    public ProjectDto toDto(ProjectEntity entity) {
        if (entity == null) {
            return null;
        }
        ProjectDto dto = new ProjectDto();
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        if (entity.getSite() != null) {
            dto.setSiteId(siteMapper.toDto(entity.getSite()));
        }
        dto.setStartTime(entity.getStartTime());
        dto.setEndTime(entity.getEndTime());
        dto.setStatus(entity.getStatus());
        mapAuditToDto(entity, dto);
        return dto;
    }

    @Override
    public ProjectEntity toEntity(ProjectDto dto) {
        if (dto == null) {
            return null;
        }
        ProjectEntity entity = new ProjectEntity();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        if (dto.getSiteId() != null) {
            entity.setSite(siteMapper.toEntity(dto.getSiteId()));
        }
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime());
        entity.setStatus(dto.getStatus());
        mapAuditToEntity(dto, entity);
        return entity;
    }
}
