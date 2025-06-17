package com.example.hospital.config;

import com.example.hospital.model.Employee;
import com.example.hospital.model.Patient;
import com.example.hospital.repository.EmployeeRepository;
import com.example.hospital.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepo, PatientRepository patientRepo) {
        return args -> {
            // Employees
            Employee e1 = new Employee(356712L, "cardiology", "Alonso Flores", "ON_CALL");
            Employee e2 = new Employee(564134L, "immunology", "Sam Ortega", "ON");
            Employee e3 = new Employee(761527L, "cardiology", "German Ruiz", "OFF");
            Employee e4 = new Employee(166552L, "pulmonary", "Maria Lin", "ON");
            Employee e5 = new Employee(156545L, "orthopaedic", "Paolo Rodriguez", "ON_CALL");
            Employee e6 = new Employee(172456L, "psychiatric", "John Paul Armes", "OFF");

            employeeRepo.save(e1);
            employeeRepo.save(e2);
            employeeRepo.save(e3);
            employeeRepo.save(e4);
            employeeRepo.save(e5);
            employeeRepo.save(e6);

            // Patients
            patientRepo.save(new Patient(1L, "Jaime Jordan", LocalDate.of(1984, 3, 2), e2));
            patientRepo.save(new Patient(2L, "Marian Garcia", LocalDate.of(1972, 1, 12), e2));
            patientRepo.save(new Patient(3L, "Julia Dusterdieck", LocalDate.of(1954, 6, 11), e1));
            patientRepo.save(new Patient(4L, "Steve McDuck", LocalDate.of(1931, 11, 10), e3));
            patientRepo.save(new Patient(5L, "Marian Garcia", LocalDate.of(1999, 2, 15), e6));
        };
    }
}