package com.tech.adira.app.management.civillab.model.entity.item.machine;

import com.tech.adira.app.management.civillab.common.AbstractAuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "engine")
@Getter
@Setter
@NoArgsConstructor
public class EngineEntity extends AbstractAuditableEntity {

    @Column(name = "engine_type", length = 50, nullable = false, unique = true)
    private String engineType;

    @Column(name = "engine_power", length = 50)
    private String enginePower;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
}
