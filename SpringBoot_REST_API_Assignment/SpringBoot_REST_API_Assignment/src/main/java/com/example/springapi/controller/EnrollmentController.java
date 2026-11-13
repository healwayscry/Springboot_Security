package com.example.springapi.controller;

import com.example.springapi.entity.Enrollment;
import com.example.springapi.service.EnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    private final EnrollmentService service;

    public EnrollmentController(EnrollmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Enrollment> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Enrollment getById(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Enrollment create(@RequestBody Enrollment enrollment) {
        return service.create(enrollment);
    }

    @PutMapping("/{id}")
    public Enrollment update(@PathVariable Long id, @RequestBody Enrollment enrollment) {
        return service.update(id, enrollment);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
