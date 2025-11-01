package com.tech.adira.app.management.civillab.model.dto.payroll.rate;

import java.time.Instant;
import java.time.LocalDate;

import com.tech.adira.app.management.civillab.model.dto.employee.EmployeeDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TimesheetDto {

    private EmployeeDto employee;

    private LocalDate workDate;

    private int totalHours = 0;

    private String remarks;

    private String createdBy;

    private Instant createdDate;

    private String lastModifiedBy;

    private Instant lastModifiedDate;
}
