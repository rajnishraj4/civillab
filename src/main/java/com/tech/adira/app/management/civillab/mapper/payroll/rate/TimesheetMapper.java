package com.tech.adira.app.management.civillab.mapper.payroll.rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tech.adira.app.management.civillab.mapper.employee.EmployeeMapper;
import com.tech.adira.app.management.civillab.model.dto.payroll.rate.TimesheetDto;
import com.tech.adira.app.management.civillab.model.entity.payroll.rate.TimesheetEntity;

@Component
public class TimesheetMapper {

    private final EmployeeMapper employeeMapper;

    @Autowired
    public TimesheetMapper(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    public TimesheetDto toDto(TimesheetEntity entity) {
        if (entity == null) {
            return null;
        }
        TimesheetDto dto = new TimesheetDto();
        dto.setEmployee(employeeMapper.toDto(entity.getEmployee()));
        dto.setWorkDate(entity.getWorkDate());
        dto.setTotalHours(entity.getTotalHours());
        dto.setRemarks(entity.getRemarks());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setLastModifiedBy(entity.getLastModifiedBy());
        dto.setLastModifiedDate(entity.getLastModifiedDate());
        return dto;
    }

    public TimesheetEntity toEntity(TimesheetDto dto) {
        if (dto == null) {
            return null;
        }
        TimesheetEntity entity = new TimesheetEntity();
        entity.setEmployee(employeeMapper.toEntity(dto.getEmployee()));
        entity.setWorkDate(dto.getWorkDate());
        entity.setTotalHours(dto.getTotalHours());
        entity.setRemarks(dto.getRemarks());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setLastModifiedBy(dto.getLastModifiedBy());
        entity.setLastModifiedDate(dto.getLastModifiedDate());
        return entity;
    }
}
