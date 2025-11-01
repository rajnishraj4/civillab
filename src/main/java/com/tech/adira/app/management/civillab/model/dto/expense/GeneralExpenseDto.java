package com.tech.adira.app.management.civillab.model.dto.expense;

import com.tech.adira.app.management.civillab.common.AbstractAuditableDto;
import com.tech.adira.app.management.civillab.constants.expense.ExpenseStatus;
import com.tech.adira.app.management.civillab.model.dto.item.GeneralItemDto;
import com.tech.adira.app.management.civillab.model.dto.project.ProjectDto;
import com.tech.adira.app.management.civillab.model.dto.project.SiteDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeneralExpenseDto extends AbstractAuditableDto {

    private LocalDate expenseDate;
    private String description;
    private BigDecimal amount;
    private String itemId;
    private GeneralItemDto item;
    private BigDecimal quantity;
    private String unit;
    private ExpenseStatus expenseStatus;
    private SiteDto site;
    private ProjectDto project;
    private String receiptPath;
}
