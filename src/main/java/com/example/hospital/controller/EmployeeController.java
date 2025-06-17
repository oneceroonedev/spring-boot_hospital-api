package com.example.hospital.controller;

import com.example.hospital.model.Employee;
import com.example.hospital.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class EmployeeController {

    private final EmployeeRepository employeeRepo;

    public EmployeeController(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    // Get all doctors
    @GetMapping
    public List<Employee> getAllDoctors() {
        return employeeRepo.findAll();
    }

    // Get doctor by ID
    @GetMapping("/{id}")
    public Optional<Employee> getDoctorById(@PathVariable Long id) {
        return employeeRepo.findById(id);
    }

    // Get doctors by status
    @GetMapping("/status/{status}")
    public List<Employee> getDoctorsByStatus(@PathVariable String status) {
        return employeeRepo.findByStatus(status.toUpperCase());
    }

    // Get doctors by department
    @GetMapping("/department/{department}")
    public List<Employee> getDoctorsByDepartment(@PathVariable String department) {
        return employeeRepo.findByDepartment(department.toLowerCase());
    }
}