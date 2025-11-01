package com.tech.adira.app.management.civillab.mapper.expense;

import com.tech.adira.app.management.civillab.common.AbstractAuditableMapper;
import com.tech.adira.app.management.civillab.model.dto.expense.EquipmentExpenseDto;
import com.tech.adira.app.management.civillab.model.entity.expense.EquipmentExpenseEntity;
import com.tech.adira.app.management.civillab.mapper.item.machine.EquipmentMapper;
import com.tech.adira.app.management.civillab.mapper.project.ProjectMapper;
import com.tech.adira.app.management.civillab.mapper.project.SiteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EquipmentExpenseMapper extends AbstractAuditableMapper<EquipmentExpenseEntity, EquipmentExpenseDto> {

    private final EquipmentMapper equipmentMapper;
    private final MachineExpenseTypeMapper typeMapper;
    private final SiteMapper siteMapper;
    private final ProjectMapper projectMapper;

    @Autowired
    public EquipmentExpenseMapper(EquipmentMapper equipmentMapper,
                                  MachineExpenseTypeMapper typeMapper,
                                  SiteMapper siteMapper,
                                  ProjectMapper projectMapper) {
        this.equipmentMapper = equipmentMapper;
        this.typeMapper = typeMapper;
        this.siteMapper = siteMapper;
        this.projectMapper = projectMapper;
    }

    @Override
    public EquipmentExpenseDto toDto(EquipmentExpenseEntity entity) {
        if (entity == null) return null;
        EquipmentExpenseDto dto = new EquipmentExpenseDto();
        dto.setExpenseDate(entity.getExpenseDate());
        dto.setDescription(entity.getDescription());
        dto.setAmount(entity.getAmount());
        if (entity.getEquipment() != null) {
            dto.setEquipment(equipmentMapper.toDto(entity.getEquipment()));
        }
        dto.setQuantity(entity.getQuantity());
        dto.setExpenseStatus(entity.getExpenseStatus());
        if (entity.getSite() != null) {
            dto.setSite(siteMapper.toDto(entity.getSite()));
        }
        if (entity.getProject() != null) {
            dto.setProject(projectMapper.toDto(entity.getProject()));
        }
        dto.setReceiptPath(entity.getReceiptPath());
        mapAuditToDto(entity, dto);
        return dto;
    }

    @Override
    public EquipmentExpenseEntity toEntity(EquipmentExpenseDto dto) {
        if (dto == null) return null;
        EquipmentExpenseEntity entity = new EquipmentExpenseEntity();
        entity.setExpenseDate(dto.getExpenseDate());
        entity.setDescription(dto.getDescription());
        entity.setAmount(dto.getAmount());
        if (dto.getEquipment() != null) {
            entity.setEquipment(equipmentMapper.toEntity(dto.getEquipment()));
        }
        entity.setQuantity(dto.getQuantity());
        entity.setExpenseStatus(dto.getExpenseStatus());
        if (dto.getSite() != null) {
            entity.setSite(siteMapper.toEntity(dto.getSite()));
        }
        if (dto.getProject() != null) {
            entity.setProject(projectMapper.toEntity(dto.getProject()));
        }
        entity.setReceiptPath(dto.getReceiptPath());
        mapAuditToEntity(dto, entity);
        return entity;
    }
}
