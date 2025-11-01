package com.tech.adira.app.management.civillab.model.entity.payroll.rate;

import com.tech.adira.app.management.civillab.model.entity.employee.EmployeeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "timesheet")
@Getter
@Setter
@NoArgsConstructor
@IdClass(DailyWorkerHoursId.class)
public class TimesheetEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeEntity employee;

    @Id
    @Column(name = "work_date", nullable = false)
    private LocalDate workDate;

    @Column(name = "total_hours", nullable = false)
    private int totalHours = 0;

    @Column(name = "remarks", columnDefinition = "TEXT")
    private String remarks;

    @Column(name = "created_by", updatable = false, length = 100)
    protected String createdBy;

    @Column(name = "created_at", updatable = false, nullable = false)
    protected Instant createdDate;

    @Column(name = "updated_by", length = 100)
    protected String lastModifiedBy;

    @Column(name = "updated_at", nullable = false)
    protected Instant lastModifiedDate;
}
