package com.tech.adira.app.management.civillab.model.dto.payroll.wage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class WageDeductionDto {

    private WageSlipDto wageSlip;

    private short lineSequence;

    private String description;

    private BigDecimal amount;

    private String createdBy;

    private Instant createdDate;

    private String lastModifiedBy;

    private Instant lastModifiedDate;
}
