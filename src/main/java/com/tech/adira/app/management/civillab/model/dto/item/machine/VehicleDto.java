package com.tech.adira.app.management.civillab.model.dto.item.machine;

import com.tech.adira.app.management.civillab.common.AbstractAuditableDto;
import com.tech.adira.app.management.civillab.common.Machine;
import com.tech.adira.app.management.civillab.constants.management.OwnershipType;
import com.tech.adira.app.management.civillab.model.dto.project.ProjectDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto extends AbstractAuditableDto implements Machine {
    private String vehicleName;
    private String equipmentNumber;
    private OwnershipType ownershipType;
    private String ownerName;
    private EngineDto engine;
    private ProjectDto project;
}
