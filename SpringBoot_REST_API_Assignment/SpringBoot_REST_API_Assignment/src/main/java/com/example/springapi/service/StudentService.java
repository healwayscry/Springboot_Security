package com.example.springapi.service;

import com.example.springapi.entity.Student;
import com.example.springapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> findAll() { return repository.findAll(); }

    public Student findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found: " + id));
    }

    public Student create(Student student) { return repository.save(student); }

    public Student update(Long id, Student data) {
        Student student = findById(id);
        student.setName(data.getName());
        student.setEmail(data.getEmail());
        student.setMajor(data.getMajor());
        return repository.save(student);
    }

    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
