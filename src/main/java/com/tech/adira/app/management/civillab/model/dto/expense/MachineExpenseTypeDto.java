package com.tech.adira.app.management.civillab.model.dto.expense;

import com.tech.adira.app.management.civillab.common.AbstractAuditableDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object for MachineExpenseTypeEntity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MachineExpenseTypeDto extends AbstractAuditableDto {
    private String typeName;
    private String category;
}
