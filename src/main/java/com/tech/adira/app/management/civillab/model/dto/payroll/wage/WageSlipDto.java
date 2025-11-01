package com.tech.adira.app.management.civillab.model.dto.payroll.wage;

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
public class WageSlipDto extends AbstractAuditableDto {

    private EmployeeDto employee;

    private LocalDate payPeriodStart;

    private LocalDate payPeriodEnd;

    private LocalDate slipDate;

    private BigDecimal totalEarnings;

    private BigDecimal totalDeductions = BigDecimal.ZERO;

    private BigDecimal netPayable;
}
