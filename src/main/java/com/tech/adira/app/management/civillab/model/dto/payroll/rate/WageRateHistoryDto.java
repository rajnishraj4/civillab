package com.tech.adira.app.management.civillab.model.dto.payroll.rate;

import com.tech.adira.app.management.civillab.common.AbstractAuditableDto;
import com.tech.adira.app.management.civillab.model.dto.employee.EmployeeDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class WageRateHistoryDto extends AbstractAuditableDto {

    private EmployeeDto employee;

    private BigDecimal hourlyRate;

    private LocalDate effectiveFromDate;

    private LocalDate effectiveToDate;
}
