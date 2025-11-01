package com.tech.adira.app.management.civillab.mapper.expense;

import com.tech.adira.app.management.civillab.common.AbstractAuditableMapper;
import com.tech.adira.app.management.civillab.model.dto.expense.VehicleExpenseDto;
import com.tech.adira.app.management.civillab.model.entity.expense.VehicleExpenseEntity;
import com.tech.adira.app.management.civillab.mapper.item.machine.VehicleMapper;
import com.tech.adira.app.management.civillab.mapper.project.ProjectMapper;
import com.tech.adira.app.management.civillab.mapper.project.SiteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleExpenseMapper extends AbstractAuditableMapper<VehicleExpenseEntity, VehicleExpenseDto> {

    private final VehicleMapper vehicleMapper;
    private final MachineExpenseTypeMapper typeMapper;
    private final SiteMapper siteMapper;
    private final ProjectMapper projectMapper;

    @Autowired
    public VehicleExpenseMapper(VehicleMapper vehicleMapper,
                                MachineExpenseTypeMapper typeMapper,
                                SiteMapper siteMapper,
                                ProjectMapper projectMapper) {
        this.vehicleMapper = vehicleMapper;
        this.typeMapper = typeMapper;
        this.siteMapper = siteMapper;
        this.projectMapper = projectMapper;
    }

    @Override
    public VehicleExpenseDto toDto(VehicleExpenseEntity entity) {
        if (entity == null) return null;
        VehicleExpenseDto dto = new VehicleExpenseDto();
        dto.setExpenseDate(entity.getExpenseDate());
        dto.setDescription(entity.getDescription());
        dto.setAmount(entity.getAmount());
        if (entity.getVehicle() != null) {
            dto.setVehicle(vehicleMapper.toDto(entity.getVehicle()));
        }
        dto.setQuantity(entity.getQuantity());
        mapAuditToDto(entity, dto);
        dto.setExpenseStatus(entity.getExpenseStatus());
        if (entity.getSite() != null) {
            dto.setSite(siteMapper.toDto(entity.getSite()));
        }
        if (entity.getProject() != null) {
            dto.setProject(projectMapper.toDto(entity.getProject()));
        }
        dto.setReceiptPath(entity.getReceiptPath());
        return dto;
    }

    @Override
    public VehicleExpenseEntity toEntity(VehicleExpenseDto dto) {
        if (dto == null) return null;
        VehicleExpenseEntity entity = new VehicleExpenseEntity();
        entity.setExpenseDate(dto.getExpenseDate());
        entity.setDescription(dto.getDescription());
        entity.setAmount(dto.getAmount());
        if (dto.getVehicle() != null) {
            entity.setVehicle(vehicleMapper.toEntity(dto.getVehicle()));
        }
        entity.setQuantity(dto.getQuantity());
        mapAuditToEntity(dto, entity);
        entity.setExpenseStatus(dto.getExpenseStatus());
        if (dto.getSite() != null) {
            entity.setSite(siteMapper.toEntity(dto.getSite()));
        }
        if (dto.getProject() != null) {
            entity.setProject(projectMapper.toEntity(dto.getProject()));
        }
        entity.setReceiptPath(dto.getReceiptPath());
        return entity;
    }
}

