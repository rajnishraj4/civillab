package com.tech.adira.app.management.civillab.model.dto.employee;

import com.tech.adira.app.management.civillab.common.AbstractAuditableDto;
import com.tech.adira.app.management.civillab.constants.employee.EmployeeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto extends AbstractAuditableDto {
    private String firstName;
    private String lastName;
    private String aadhaarNumber;
    private String dateOfBirth;
    private String gender;
    private boolean isVerified;
    private EmployeeType employeeType;
}