package com.tech.adira.app.management.civillab.model.dto.item.machine;

import com.tech.adira.app.management.civillab.common.AbstractAuditableDto;
import com.tech.adira.app.management.civillab.common.Machine;
import com.tech.adira.app.management.civillab.constants.management.OwnershipType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object for EquipmentEntity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDto extends AbstractAuditableDto implements Machine {
    private String equipmentName;
    private String equipmentNumber;
    private OwnershipType ownership;
    private String ownerName;
    private EngineDto engine;
}
