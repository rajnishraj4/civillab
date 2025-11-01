package com.tech.adira.app.management.civillab.repository;

import com.tech.adira.app.management.civillab.model.entity.management.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, String> {
}
