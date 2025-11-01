package com.tech.adira.app.management.civillab.model.entity.payroll.rate;

import com.tech.adira.app.management.civillab.common.AbstractAuditableEntity;
import com.tech.adira.app.management.civillab.model.entity.employee.EmployeeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "wage_rate_history",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"employee_id", "effective_from_date"})})
@Getter
@Setter
@NoArgsConstructor
public class WageRateHistoryEntity extends AbstractAuditableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_wage_rate_history_employee"))
    private EmployeeEntity employee;

    @Column(name = "hourly_rate", precision = 8, scale = 2, nullable = false)
    private BigDecimal hourlyRate;

    @Column(name = "effective_from_date", nullable = false)
    private LocalDate effectiveFromDate;

    @Column(name = "effective_to_date")
    private LocalDate effectiveToDate;
}
