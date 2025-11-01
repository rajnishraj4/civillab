package com.tech.adira.app.management.civillab.common;

/**
 * Mapper interface for entities and DTOs that include auditable fields.
 * <p>
 * Extends the base {@link Mapper} interface by adding methods to map audit-related properties
 * such as createdBy, createdDate, lastModifiedBy, and lastModifiedDate.
 *
 * @param <E> the entity type
 * @param <D> the DTO type
 */
public interface AuditableMapper <E, D>extends Mapper<E, D>{
    /**
     * Maps auditable fields from the given entity to the DTO.
     * Typical audit fields include createdBy, createdDate, lastModifiedBy, and lastModifiedDate.
     *
     * @param entity the source entity object
     * @param dto    the target DTO object
     */
    void mapAuditToDto(E entity, D dto);
    /**
     * Maps auditable fields from the given DTO to the entity.
     * Typical audit fields include createdBy, createdDate, lastModifiedBy, and lastModifiedDate.
     *
     * @param dto    the source DTO object
     * @param entity the target entity object
     */
    void mapAuditToEntity(D dto, E entity);
}
