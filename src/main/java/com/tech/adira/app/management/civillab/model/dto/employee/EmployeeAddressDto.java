package com.tech.adira.app.management.civillab.model.dto.employee;

import com.tech.adira.app.management.civillab.common.AbstractAuditableDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAddressDto extends AbstractAuditableDto {

    private String streetAddress;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
