package com.tech.adira.app.management.civillab.model.entity.item.machine;

import com.tech.adira.app.management.civillab.common.AbstractAuditableEntity;
import com.tech.adira.app.management.civillab.common.Machine;
import com.tech.adira.app.management.civillab.constants.management.OwnershipType;
import com.tech.adira.app.management.civillab.model.entity.project.ProjectEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
@NoArgsConstructor
public class VehicleEntity extends AbstractAuditableEntity implements Machine {

    @Column(name = "vehicle_name", nullable = false)
    private String vehicleName;

    @Column(name = "vehicle_number", nullable = false)
    private String vehicleNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "ownership_type", nullable = false, length = 20)
    private OwnershipType ownershipType;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "engine_id", referencedColumnName = "id")
    private EngineEntity engine;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "project_id", referencedColumnName = "id")
     private ProjectEntity project;
}
