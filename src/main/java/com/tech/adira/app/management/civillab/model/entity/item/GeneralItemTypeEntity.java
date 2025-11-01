package com.tech.adira.app.management.civillab.model.entity.item;

import com.tech.adira.app.management.civillab.common.AbstractAuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "general_item_type")
@Getter
@Setter
@NoArgsConstructor
public class GeneralItemTypeEntity extends AbstractAuditableEntity {

    @Column(name = "type_name", nullable = false)
    private String typeName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
}
