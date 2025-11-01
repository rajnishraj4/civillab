package com.tech.adira.app.management.civillab.mapper.item.machine;

import com.tech.adira.app.management.civillab.common.AbstractAuditableMapper;
import com.tech.adira.app.management.civillab.model.dto.item.machine.VehicleDto;
import com.tech.adira.app.management.civillab.model.entity.item.machine.VehicleEntity;
import com.tech.adira.app.management.civillab.mapper.project.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VehicleMapper extends AbstractAuditableMapper<VehicleEntity, VehicleDto> {

    private final EngineMapper engineMapper;
    private final ProjectMapper projectMapper;

    @Autowired
    public VehicleMapper(EngineMapper engineMapper, ProjectMapper projectMapper) {
        this.engineMapper = engineMapper;
        this.projectMapper = projectMapper;
    }

    @Override
    public VehicleDto toDto(VehicleEntity entity) {
        if (entity == null) {
            return null;
        }
        VehicleDto dto = new VehicleDto();
        Optional.ofNullable(entity.getVehicleName()).ifPresent(dto::setVehicleName);
        Optional.ofNullable(entity.getOwnershipType()).ifPresent(dto::setOwnershipType);
        Optional.ofNullable(entity.getOwnerName()).ifPresent(dto::setOwnerName);

        if (entity.getEngine() != null) {
            dto.setEngine(engineMapper.toDto(entity.getEngine()));
        }

        if (entity.getProject() != null) {
            dto.setProject(projectMapper.toDto(entity.getProject()));
        }

        mapAuditToDto(entity, dto);
        return dto;
    }

    @Override
    public VehicleEntity toEntity(VehicleDto dto) {
        if (dto == null) {
            return null;
        }
        VehicleEntity entity = new VehicleEntity();
        Optional.ofNullable(dto.getVehicleName()).ifPresent(entity::setVehicleName);
        Optional.ofNullable(dto.getOwnershipType()).ifPresent(entity::setOwnershipType);
        Optional.ofNullable(dto.getOwnerName()).ifPresent(entity::setOwnerName);

        if (dto.getEngine() != null) {
            entity.setEngine(engineMapper.toEntity(dto.getEngine()));
        }

        if (dto.getProject() != null) {
            entity.setProject(projectMapper.toEntity(dto.getProject()));
        }

        mapAuditToEntity(dto, entity);
        return entity;
    }
}
