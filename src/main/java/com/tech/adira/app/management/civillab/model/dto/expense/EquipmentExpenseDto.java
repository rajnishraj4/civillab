package com.tech.adira.app.management.civillab.model.dto.expense;

import com.tech.adira.app.management.civillab.common.AbstractAuditableDto;
import com.tech.adira.app.management.civillab.constants.expense.ExpenseStatus;
import com.tech.adira.app.management.civillab.model.dto.item.machine.EquipmentDto;
import com.tech.adira.app.management.civillab.model.dto.project.ProjectDto;
import com.tech.adira.app.management.civillab.model.dto.project.SiteDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Data Transfer Object for EquipmentExpenseEntity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentExpenseDto extends AbstractAuditableDto {

    private LocalDate expenseDate;
    private String description;
    private BigDecimal amount;
    private EquipmentDto equipment;
    private int quantity;
    private MachineExpenseTypeDto expenseType;
    private ExpenseStatus expenseStatus;
    private SiteDto site;
    private ProjectDto project;
    private String receiptPath;
}
