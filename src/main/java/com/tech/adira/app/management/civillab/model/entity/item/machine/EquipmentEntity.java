package com.tech.adira.app.management.civillab.model.entity.item.machine;

import com.tech.adira.app.management.civillab.common.AbstractAuditableEntity;
import com.tech.adira.app.management.civillab.common.Machine;
import com.tech.adira.app.management.civillab.constants.management.OwnershipType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "equipment")
@Getter
@Setter
@NoArgsConstructor
public class EquipmentEntity extends AbstractAuditableEntity implements Machine {

    @Column(name = "equipment_name", nullable = false)
    private String equipmentName;

    @Column(name = "equipment_number", nullable = false)
    private String equipmentNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "ownership", length = 20, nullable = false)
    private OwnershipType ownership;

    @Column(name = "owner_name", length = 255, nullable = false)
    private String ownerName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "engine_id", referencedColumnName = "id")
    private EngineEntity engine;
}
