package com.tech.adira.app.management.civillab.model.entity.management;

import com.tech.adira.app.management.civillab.common.AbstractAuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoleEntity extends AbstractAuditableEntity {

    @Column(name = "role_name", length = 100, nullable = false, unique = true)
    private String roleName;
}
