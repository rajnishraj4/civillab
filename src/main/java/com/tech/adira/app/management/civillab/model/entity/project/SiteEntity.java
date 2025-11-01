package com.tech.adira.app.management.civillab.model.entity.project;

import com.tech.adira.app.management.civillab.common.AbstractAuditableEntity;
import com.tech.adira.app.management.civillab.constants.management.ActiveStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "site")
@Getter
@Setter
@NoArgsConstructor
public class SiteEntity extends AbstractAuditableEntity {
    @Column(name = "site_name", nullable = false)
    private String siteName;

    @Column(name = "location", length = 500)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ActiveStatus status = ActiveStatus.ACTIVE;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
}
