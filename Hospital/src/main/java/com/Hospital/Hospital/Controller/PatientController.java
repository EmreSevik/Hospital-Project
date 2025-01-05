package com.Hospital.Hospital.Controller;

import com.Hospital.Hospital.Entity.Patient;
import com.Hospital.Hospital.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    public ResponseEntity<String> registerPatient(@RequestBody Patient patient) {
        try {
            System.out.println("Kayıt edilen hasta: " + patient.getName());
            patientRepository.save(patient);
            return ResponseEntity.ok("Hasta başarıyla kaydedildi!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Kayıt işlemi sırasında hata oluştu.");
        }
    }
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        try {
            List<Patient> patients = patientRepository.findAll();
            return ResponseEntity.ok(patients);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }



}
