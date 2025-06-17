package com.example.hospital.controller;

import com.example.hospital.model.Patient;
import com.example.hospital.repository.PatientRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientRepository patientRepo;

    public PatientController(PatientRepository patientRepo) {
        this.patientRepo = patientRepo;
    }

    // Get all patients
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    // Get patient by ID
    @GetMapping("/{id}")
    public Optional<Patient> getPatientById(@PathVariable Long id) {
        return patientRepo.findById(id);
    }

    // Get patients by date of birth range
    @GetMapping("/dob")
    public List<Patient> getPatientsByDateRange(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end
    ) {
        return patientRepo.findByDateOfBirthBetween(start, end);
    }

    // Get patients by admitting doctor's department
    @GetMapping("/by-department/{department}")
    public List<Patient> getPatientsByDoctorDepartment(@PathVariable String department) {
        return patientRepo.findByAdmittedBy_Department(department.toLowerCase());
    }

    // Get patients whose admitting doctor has status OFF
    @GetMapping("/by-doctor-status/OFF")
    public List<Patient> getPatientsWithDoctorStatusOff() {
        return patientRepo.findByAdmittedBy_Status("OFF");
    }
}