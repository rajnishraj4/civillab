package com.tech.adira.app.management.civillab.model.dto.management;

import com.tech.adira.app.management.civillab.common.AbstractAuditableDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto extends AbstractAuditableDto {
    private String roleName;
}
