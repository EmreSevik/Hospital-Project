package com.Hospital.Hospital.Controller;

import com.Hospital.Hospital.Entity.Doctor;
import com.Hospital.Hospital.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        if (doctors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(doctors);
    }

    @PostMapping
    public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor) {
        doctorRepository.save(doctor);
        return ResponseEntity.ok("Doktor başarıyla eklendi!");
    }
}
