package com.example.courseService.service;

import com.example.courseService.model.CourseModel;
import com.example.courseService.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
  @Autowired
  CourseRepository courseRepository;

  public CourseModel registerCourse(CourseModel courseModel) {
    return courseRepository.save(courseModel);
  }

  public List<CourseModel> findAllCourses() {
    return courseRepository.findAll();
  }

  public Optional<CourseModel> findOneCourse(Long id) {
    return courseRepository.findById(id);
  }

  public void deleteCourse(Long id) {
    courseRepository.deleteById(id);
  }
}
