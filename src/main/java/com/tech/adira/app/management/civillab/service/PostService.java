package com.tech.adira.app.management.civillab.service;

import com.tech.adira.app.management.civillab.exception.InvalidDataException;
import com.tech.adira.app.management.civillab.exception.ResourceNotFoundException;
import com.tech.adira.app.management.civillab.mapper.management.PostMapper;
import com.tech.adira.app.management.civillab.repository.PostRepository;
import com.tech.adira.app.management.civillab.utils.UlidUtils;
import com.tech.adira.app.management.civillab.model.dto.management.PostDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository repo;
    private final PostMapper mapper;

    public PostService(PostRepository repo, PostMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Transactional
    public PostDto create(PostDto dto) {
        if (dto.getPostName() == null || dto.getPostName().isBlank()) {
            throw new InvalidDataException("postName required");
        }
        if (dto.getId() == null) {
            dto.setId(UlidUtils.nextId());
        }
        var entity = mapper.toEntity(dto);
        var now = Instant.now();
        entity.setCreatedDate(now);
        entity.setLastModifiedDate(now);
        try {
            entity = repo.save(entity);
            return mapper.toDto(entity);
        } catch (DataIntegrityViolationException ex) {
            throw new InvalidDataException("postName must be unique", ex);
        }
    }

    public PostDto getById(String id) {
        return repo.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found"));
    }

    public Page<PostDto> list(Pageable pg) {
        return repo.findAll(pg).map(mapper::toDto);
    }

    @Transactional
    public PostDto update(String id, PostDto dto) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Post not found");
        }
        if (dto.getPostName() == null || dto.getPostName().isBlank()) {
            throw new InvalidDataException("postName required");
        }
        var entity = mapper.toEntity(dto);
        entity.setId(id);
        entity.setLastModifiedDate(Instant.now());
        try {
            entity = repo.save(entity);
            return mapper.toDto(entity);
        } catch (DataIntegrityViolationException ex) {
            throw new InvalidDataException("postName must be unique", ex);
        }
    }

    @Transactional
    public void delete(String id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Post not found");
        }
        repo.deleteById(id);
    }
}
