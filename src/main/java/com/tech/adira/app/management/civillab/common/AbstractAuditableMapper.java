package com.tech.adira.app.management.civillab.common;

import java.util.Optional;

public abstract class AbstractAuditableMapper<E extends AbstractAuditableEntity, D extends AbstractAuditableDto>
        implements AuditableMapper<E, D> {

    @Override
    public void mapAuditToDto(E entity, D dto) {
        if (entity == null || dto == null) {
            return;
        }
        Optional.ofNullable(entity.getId()).ifPresent(dto::setId);
        entity.getCreatedBy().ifPresent(dto::setCreatedBy);
        entity.getCreatedDate().ifPresent(dto::setCreatedDate);
        entity.getLastModifiedBy().ifPresent(dto::setLastModifiedBy);
        entity.getLastModifiedDate().ifPresent(dto::setLastModifiedDate);
    }

    @Override
    public void mapAuditToEntity(D dto, E entity) {
        if (entity == null || dto == null) {
            return;
        }
        Optional.ofNullable(dto.getId()).ifPresent(entity::setId);
        dto.getCreatedBy().ifPresent(entity::setCreatedBy);
        dto.getCreatedDate().ifPresent(entity::setCreatedDate);
        dto.getLastModifiedBy().ifPresent(entity::setLastModifiedBy);
        dto.getLastModifiedDate().ifPresent(entity::setLastModifiedDate);
    }

    public abstract D toDto(E entity);

    public abstract E toEntity(D dto);
}


