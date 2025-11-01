package com.tech.adira.app.management.civillab.service;

import com.tech.adira.app.management.civillab.exception.InvalidDataException;
import com.tech.adira.app.management.civillab.exception.ResourceNotFoundException;
import com.tech.adira.app.management.civillab.mapper.management.RoleMapper;
import com.tech.adira.app.management.civillab.repository.RoleRepository;
import com.tech.adira.app.management.civillab.utils.UlidUtils;
import com.tech.adira.app.management.civillab.model.dto.management.RoleDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@Transactional(readOnly = true)
public class RoleService {

    private final RoleRepository repo;
    private final RoleMapper mapper;

    public RoleService(RoleRepository repo, RoleMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Transactional
    public RoleDto create(RoleDto dto) {
        if (dto.getRoleName() == null || dto.getRoleName().isBlank()) {
            throw new InvalidDataException("roleName required");
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
            throw new InvalidDataException("roleName must be unique", ex);
        }
    }

    public RoleDto getById(String id) {
        return repo.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));
    }

    public Page<RoleDto> list(Pageable pg) {
        return repo.findAll(pg).map(mapper::toDto);
    }

    @Transactional
    public RoleDto update(String id, RoleDto dto) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Role not found");
        }
        if (dto.getRoleName() == null || dto.getRoleName().isBlank()) {
            throw new InvalidDataException("roleName required");
        }
        var entity = mapper.toEntity(dto);
        entity.setId(id);
        entity.setLastModifiedDate(Instant.now());
        try {
            entity = repo.save(entity);
            return mapper.toDto(entity);
        } catch (DataIntegrityViolationException ex) {
            throw new InvalidDataException("roleName must be unique", ex);
        }
    }

    @Transactional
    public void delete(String id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Role not found");
        }
        repo.deleteById(id);
    }
}

