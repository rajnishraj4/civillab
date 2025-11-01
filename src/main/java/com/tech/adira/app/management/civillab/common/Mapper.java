package com.tech.adira.app.management.civillab.common;

public interface Mapper <E, D>{
    /**
     * Convert Entity Object to Dto Object
     */
    D toDto(E entity);
    /**
     * Convert Dto Object to Entity Object
     */
    E toEntity(D dto);
}
