package com.tech.adira.app.management.civillab.model.dto.employee;

import com.tech.adira.app.management.civillab.common.AbstractAuditableDto;
import com.tech.adira.app.management.civillab.constants.employee.ContactType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeContactDto extends AbstractAuditableDto {
    private ContactType contactType;
    private String contactDetail;
}
