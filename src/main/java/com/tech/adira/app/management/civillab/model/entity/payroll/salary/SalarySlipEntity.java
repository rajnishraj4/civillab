package com.tech.adira.app.management.civillab.model.entity.payroll.salary;

import com.tech.adira.app.management.civillab.common.AbstractAuditableEntity;
import com.tech.adira.app.management.civillab.model.entity.employee.EmployeeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "salary_slip",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"employee_id", "pay_period_start", "pay_period_end"})})
@Getter
@Setter
@NoArgsConstructor
public class SalarySlipEntity extends AbstractAuditableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_salary_slip_employee"))
    private EmployeeEntity employee;

    @Column(name = "pay_period_start", nullable = false)
    private LocalDate payPeriodStart;

    @Column(name = "pay_period_end", nullable = false)
    private LocalDate payPeriodEnd;

    @Column(name = "slip_date", nullable = false)
    private LocalDate slipDate;

    @Column(name = "gross_salary", precision = 12, scale = 2, nullable = false)
    private BigDecimal grossSalary;

    @Column(name = "total_earnings", precision = 12, scale = 2, nullable = false)
    private BigDecimal totalEarnings;

    @Column(name = "total_deductions", precision = 12, scale = 2, nullable = false)
    private BigDecimal totalDeductions = BigDecimal.ZERO;

    @Column(name = "net_payable", precision = 12, scale = 2, nullable = false)
    private BigDecimal netPayable;
}
