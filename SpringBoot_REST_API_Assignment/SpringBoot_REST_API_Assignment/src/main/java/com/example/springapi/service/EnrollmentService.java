package com.example.springapi.service;

import com.example.springapi.entity.Enrollment;
import com.example.springapi.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository repository;

    public EnrollmentService(EnrollmentRepository repository) {
        this.repository = repository;
    }

    public List<Enrollment> findAll() { return repository.findAll(); }

    public Enrollment findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found: " + id));
    }

    public Enrollment create(Enrollment enrollment) { return repository.save(enrollment); }

    public Enrollment update(Long id, Enrollment data) {
        Enrollment e = findById(id);
        e.setStudent(data.getStudent());
        e.setCourse(data.getCourse());
        e.setEnrolledAt(data.getEnrolledAt());
        e.setScore(data.getScore());
        return repository.save(e);
    }

    public void delete(Long id) { repository.delete(findById(id)); }
}
