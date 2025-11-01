package com.tech.adira.app.management.civillab.model.entity.expense;

import com.tech.adira.app.management.civillab.common.AbstractAuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "machine_expense_type")
@Getter
@Setter
@NoArgsConstructor
public class MachineExpenseTypeEntity extends AbstractAuditableEntity {

    @Column(name = "type_name", length = 255, nullable = false)
    private String typeName;

    @Column(name = "category", length = 100)
    private String category;
}
