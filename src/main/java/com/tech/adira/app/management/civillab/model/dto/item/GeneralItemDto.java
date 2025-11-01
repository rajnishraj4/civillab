package com.tech.adira.app.management.civillab.model.dto.item;

import com.tech.adira.app.management.civillab.common.AbstractAuditableDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object for GeneralItemEntity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeneralItemDto extends AbstractAuditableDto {
    private String typeName;
    private String description;
    private GeneralItemTypeDto generalItemType;
}
