package com.tech.adira.app.management.civillab.model.entity.payroll.salary;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@EqualsAndHashCode
public class SalaryDetailId implements Serializable {

    private String salarySlip;
    private short lineSequence;
}
