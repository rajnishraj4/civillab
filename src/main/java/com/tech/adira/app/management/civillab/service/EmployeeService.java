package com.tech.adira.app.management.civillab.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tech.adira.app.management.civillab.exception.DuplicateAadhaarException;
import com.tech.adira.app.management.civillab.exception.EmployeeNotFoundException;
import com.tech.adira.app.management.civillab.exception.InvalidEmployeeDataException;
import com.tech.adira.app.management.civillab.mapper.employee.EmployeeMapper;
import com.tech.adira.app.management.civillab.repository.EmployeeRepository;
import com.tech.adira.app.management.civillab.utils.UlidUtils;
import com.tech.adira.app.management.civillab.model.dto.employee.EmployeeDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class EmployeeService {

//    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);


    private final EmployeeRepository repo;
    private final EmployeeMapper mapper;
    private final Gson gson;

    public EmployeeService(EmployeeRepository repo, EmployeeMapper mapper, Gson gson) {
        this.repo = repo;
        this.mapper = mapper;
        this.gson = gson;
    }

    @Transactional
    public EmployeeDto create(EmployeeDto dto) {
        validate(dto);
        if (dto.getId() == null) dto.setId(UlidUtils.nextId());
        var now = Instant.now();
        var entity = mapper.toEntity(dto);
        entity.setCreatedDate(now);
        entity.setLastModifiedDate(now);
        try {
            var saved = repo.save(entity);
            return mapper.toDto(saved);
        } catch (DataIntegrityViolationException ex) {
            if (ex.getMessage().contains("aadhaar_number")) {
                throw new DuplicateAadhaarException("Aadhaar already exists");
            }
            throw new InvalidEmployeeDataException("Invalid data", ex);
        }
    }

    public EmployeeDto getById(String id) {
        return repo.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }

    public Page<EmployeeDto> list(Pageable pg) {
        return repo.findAll(pg).map(mapper::toDto);
    }

    @Transactional
    public EmployeeDto update(String id, EmployeeDto dto) {
        if (!repo.existsById(id)) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        validate(dto);
        var entity = mapper.toEntity(dto);
        entity.setId(id);
        entity.setLastModifiedDate(Instant.now());
        try {
            var saved = repo.save(entity);
            return mapper.toDto(saved);
        } catch (DataIntegrityViolationException ex) {
            if (ex.getMessage().contains("aadhaar_number")) {
                throw new DuplicateAadhaarException("Aadhaar already exists");
            }
            throw new InvalidEmployeeDataException("Invalid data", ex);
        }
    }

    @Transactional
    public void delete(String id) {
        if (!repo.existsById(id)) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        repo.deleteById(id);
    }
    @Transactional
    public EmployeeDto patch(String id, Map<String, Object> updates) {
        EmployeeDto existingDto = getById(id);

        // Convert DTO to JSON object
        JsonObject existingJson = JsonParser.parseString(gson.toJson(existingDto)).getAsJsonObject();

        // Apply updates by replacing or adding elements
        updates.forEach((key, value) -> {
            JsonElement element = gson.toJsonTree(value);
            existingJson.add(key, element);
        });

        // Deserialize updated JSON back to DTO
        EmployeeDto patchedDto = gson.fromJson(existingJson, EmployeeDto.class);

        validate(patchedDto);
        patchedDto.setLastModifiedDate(Instant.now());

        var entity = mapper.toEntity(patchedDto);
        var saved = repo.save(entity);
        return mapper.toDto(saved);
    }

    private void validate(EmployeeDto dto) {
        if (!StringUtils.hasText(dto.getFirstName())) {
            throw new InvalidEmployeeDataException("First name required");
        }
        if (!StringUtils.hasText(dto.getLastName())) {
            throw new InvalidEmployeeDataException("Last name required");
        }
        if (!StringUtils.hasText(dto.getAadhaarNumber()) || dto.getAadhaarNumber().length() != 12) {
            throw new InvalidEmployeeDataException("Valid 12-digit Aadhaar required");
        }
        if (dto.getEmployeeType() == null) {
            throw new InvalidEmployeeDataException("Employee type required");
        }
    }
}