package com.tech.adira.app.management.civillab.model.entity.payroll.wage;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
public class WageDetailId implements Serializable {

    private String wageSlip;
    private short lineSequence;
}
