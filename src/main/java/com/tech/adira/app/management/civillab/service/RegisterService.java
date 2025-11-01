package com.tech.adira.app.management.civillab.service;

import com.tech.adira.app.management.civillab.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final EmployeeRepository employeeRepository;

    public RegisterService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // ===================== Create =====================
//    public EmployeeDto createEmployee(EmployeeDto employee) {
//        return employeeRepository.save(employee);
//    }

    // ===================== Read =====================
//    public List<EmployeeDto> getAllEmployees() {
//        return employeeRepository.findAll();
//    }

//    public Optional<EmployeeDto> getEmployeeById(String id) {
//        return employeeRepository.findById(id);
//    }


}
