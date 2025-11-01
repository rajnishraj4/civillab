package com.tech.adira.app.management.civillab.model.entity.payroll.salary;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "salary_earning")
@Getter
@Setter
@NoArgsConstructor
@IdClass(SalaryDetailId.class)
public class SalaryEarningEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salary_slip_id", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_salary_earning_salary_slip"))
    private SalarySlipEntity salarySlip;

    @Id
    @Column(name = "line_sequence", nullable = false)
    private short lineSequence;

    @Column(name = "description", length = 100, nullable = false)
    private String description;

    @Column(name = "amount", precision = 12, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "created_by", updatable = false, length = 100)
    protected String createdBy;

    @Column(name = "created_at", updatable = false, nullable = false)
    protected Instant createdDate;

    @Column(name = "updated_by", length = 100)
    protected String lastModifiedBy;

    @Column(name = "updated_at", nullable = false)
    protected Instant lastModifiedDate;
}
