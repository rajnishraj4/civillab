package com.tech.adira.app.management.civillab.model.entity.payroll.rate;

import com.tech.adira.app.management.civillab.common.AbstractAuditableEntity;
import com.tech.adira.app.management.civillab.model.entity.employee.EmployeeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "salary_rate_history",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"employee_id", "effective_from_date"})})
@Getter
@Setter
@NoArgsConstructor
public class SalaryRateHistoryEntity extends AbstractAuditableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_salary_rate_history_employee"))
    private EmployeeEntity employee;

    @Column(name = "basic_salary", precision = 10, scale = 2, nullable = false)
    private BigDecimal basicSalary;

    @Column(name = "effective_from_date", nullable = false)
    private LocalDate effectiveFromDate;

    @Column(name = "effective_to_date")
    private LocalDate effectiveToDate;
}
