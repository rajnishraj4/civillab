package com.tech.adira.app.management.civillab.model.dto.item.machine;

import com.tech.adira.app.management.civillab.common.AbstractAuditableDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EngineDto extends AbstractAuditableDto {
    private String engineType;
    private String enginePower;
    private String description;
}
