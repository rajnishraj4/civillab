package com.tech.adira.app.management.civillab.mapper.management;

import com.tech.adira.app.management.civillab.common.AbstractAuditableMapper;
import com.tech.adira.app.management.civillab.model.dto.management.PostDto;
import com.tech.adira.app.management.civillab.model.entity.management.PostEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PostMapper extends AbstractAuditableMapper<PostEntity, PostDto> {

    @Override
    public PostDto toDto(PostEntity entity) {
        if (entity == null) return null;

        PostDto dto = new PostDto();
        Optional.ofNullable(entity.getPostName()).ifPresent(dto::setPostName);
        mapAuditToDto(entity, dto);
        return dto;
    }

    @Override
    public PostEntity toEntity(PostDto dto) {
        if (dto == null) return null;

        PostEntity entity = new PostEntity();
        Optional.ofNullable(dto.getPostName()).ifPresent(entity::setPostName);
        mapAuditToEntity(dto, entity);
        return entity;
    }
}
