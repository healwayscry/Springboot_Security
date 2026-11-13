package com.example.springapi.service;

import com.example.springapi.entity.Course;
import com.example.springapi.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<Course> findAll() { return repository.findAll(); }

    public Course findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found: " + id));
    }

    public Course create(Course course) { return repository.save(course); }

    public Course update(Long id, Course data) {
        Course course = findById(id);
        course.setName(data.getName());
        course.setCode(data.getCode());
        course.setCredits(data.getCredits());
        return repository.save(course);
    }

    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
