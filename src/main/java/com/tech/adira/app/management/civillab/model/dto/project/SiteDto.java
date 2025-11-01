package com.tech.adira.app.management.civillab.model.dto.project;

import com.tech.adira.app.management.civillab.common.AbstractAuditableDto;
import com.tech.adira.app.management.civillab.constants.management.ActiveStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SiteDto extends AbstractAuditableDto {
    private String siteName;
    private String location;
    private ActiveStatus status;
    private String description;
}
