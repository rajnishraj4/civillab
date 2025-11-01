package com.tech.adira.app.management.civillab.model.dto.project;

import com.tech.adira.app.management.civillab.common.AbstractAuditableDto;
import com.tech.adira.app.management.civillab.constants.management.ActiveStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto extends AbstractAuditableDto {
    private String name;
    private String description;
    private SiteDto siteId;
    private Instant startTime;
    private Instant endTime;
    private ActiveStatus status;
}
