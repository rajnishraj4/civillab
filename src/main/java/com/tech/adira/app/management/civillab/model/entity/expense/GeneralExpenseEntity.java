package com.tech.adira.app.management.civillab.model.entity.expense;

import com.tech.adira.app.management.civillab.common.AbstractAuditableEntity;
import com.tech.adira.app.management.civillab.constants.expense.ExpenseStatus;
import com.tech.adira.app.management.civillab.model.entity.item.GeneralItemEntity;
import com.tech.adira.app.management.civillab.model.entity.project.ProjectEntity;
import com.tech.adira.app.management.civillab.model.entity.project.SiteEntity;
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

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "general_expense")
@Getter
@Setter
@NoArgsConstructor
public class GeneralExpenseEntity extends AbstractAuditableEntity {

    @Column(name = "expense_date", nullable = false)
    private LocalDate expenseDate;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "amount", precision = 15, scale = 2, nullable = false)
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private GeneralItemEntity item;

    @Column(name = "quantity", precision = 15, scale = 4, nullable = false)
    private BigDecimal quantity = BigDecimal.ONE;

    @Column(name = "unit", length = 30)
    private String unit;

    @Enumerated(EnumType.STRING)
    @Column(name = "expense_status", nullable = false, length = 20)
    private ExpenseStatus expenseStatus = ExpenseStatus.CREATED;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "site_id", referencedColumnName = "id")
    private SiteEntity site;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private ProjectEntity project;

    @Column(name = "receipt_path", length = 2000)
    private String receiptPath;
}

