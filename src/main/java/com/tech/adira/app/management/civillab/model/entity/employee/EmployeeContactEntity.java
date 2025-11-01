package com.tech.adira.app.management.civillab.model.entity.employee;

import com.tech.adira.app.management.civillab.common.AbstractAuditableEntity;
import com.tech.adira.app.management.civillab.constants.employee.ContactType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee_contact")
@Getter
@Setter
@NoArgsConstructor
public class EmployeeContactEntity extends AbstractAuditableEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "contact_type", nullable = false, length = 20)
    private ContactType contactType;

    @Column(name = "contact_detail", nullable = false, length = 50)
    private String contactDetail;
}
