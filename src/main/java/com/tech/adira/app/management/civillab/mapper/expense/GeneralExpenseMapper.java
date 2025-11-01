package com.tech.adira.app.management.civillab.mapper.expense;

import com.tech.adira.app.management.civillab.common.AbstractAuditableMapper;
import com.tech.adira.app.management.civillab.mapper.item.GeneralItemMapper;
import com.tech.adira.app.management.civillab.mapper.project.SiteMapper;
import com.tech.adira.app.management.civillab.model.dto.expense.GeneralExpenseDto;
import com.tech.adira.app.management.civillab.model.entity.expense.GeneralExpenseEntity;
import com.tech.adira.app.management.civillab.model.entity.item.GeneralItemEntity;
import com.tech.adira.app.management.civillab.model.entity.project.ProjectEntity;
import com.tech.adira.app.management.civillab.model.entity.project.SiteEntity;
import com.tech.adira.app.management.civillab.mapper.project.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GeneralExpenseMapper extends AbstractAuditableMapper<GeneralExpenseEntity, GeneralExpenseDto> {

    private final GeneralItemMapper generalItemMapper;
    private final SiteMapper siteMapper;
    private final ProjectMapper projectMapper;

    @Autowired
    public GeneralExpenseMapper(GeneralItemMapper generalItemMapper,
                                SiteMapper siteMapper,
                                ProjectMapper projectMapper) {
        this.generalItemMapper = generalItemMapper;
        this.siteMapper = siteMapper;
        this.projectMapper = projectMapper;
    }

    @Override
    public GeneralExpenseDto toDto(GeneralExpenseEntity entity) {
        if (entity == null) {
            return null;
        }

        GeneralExpenseDto dto = new GeneralExpenseDto();
        Optional.ofNullable(entity.getExpenseDate()).ifPresent(dto::setExpenseDate);
        Optional.ofNullable(entity.getDescription()).ifPresent(dto::setDescription);
        Optional.ofNullable(entity.getAmount()).ifPresent(dto::setAmount);
        Optional.ofNullable(entity.getQuantity()).ifPresent(dto::setQuantity);
        Optional.ofNullable(entity.getUnit()).ifPresent(dto::setUnit);
        Optional.ofNullable(entity.getExpenseStatus()).ifPresent(dto::setExpenseStatus);
        Optional.ofNullable(entity.getReceiptPath()).ifPresent(dto::setReceiptPath);

        GeneralItemEntity itemEntity = entity.getItem();
        if (itemEntity != null) {
            dto.setItem(generalItemMapper.toDto(itemEntity));
        }

        SiteEntity siteEntity = entity.getSite();
        if (siteEntity != null) {
            dto.setSite(siteMapper.toDto(siteEntity));
        }

        ProjectEntity projectEntity = entity.getProject();
        if (projectEntity != null) {
            dto.setProject(projectMapper.toDto(projectEntity));
        }

        mapAuditToDto(entity, dto);
        return dto;
    }

    @Override
    public GeneralExpenseEntity toEntity(GeneralExpenseDto dto) {
        if (dto == null) {
            return null;
        }

        GeneralExpenseEntity entity = new GeneralExpenseEntity();
        Optional.ofNullable(dto.getExpenseDate()).ifPresent(entity::setExpenseDate);
        Optional.ofNullable(dto.getDescription()).ifPresent(entity::setDescription);
        Optional.ofNullable(dto.getAmount()).ifPresent(entity::setAmount);
        Optional.ofNullable(dto.getQuantity()).ifPresent(entity::setQuantity);
        Optional.ofNullable(dto.getUnit()).ifPresent(entity::setUnit);
        Optional.ofNullable(dto.getExpenseStatus()).ifPresent(entity::setExpenseStatus);
        Optional.ofNullable(dto.getReceiptPath()).ifPresent(entity::setReceiptPath);

        if (dto.getItem() != null) {
            GeneralItemEntity itemEntity = generalItemMapper.toEntity(dto.getItem());
            entity.setItem(itemEntity);
        }

        if (dto.getSite() != null) {
            SiteEntity siteEntity = siteMapper.toEntity(dto.getSite());
            entity.setSite(siteEntity);
        }

        if (dto.getProject() != null) {
            ProjectEntity projectEntity = projectMapper.toEntity(dto.getProject());
            entity.setProject(projectEntity);
        }

        mapAuditToEntity(dto, entity);
        return entity;
    }
}
