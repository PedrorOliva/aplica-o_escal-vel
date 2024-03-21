package com.example.courseService.controller;

import com.example.courseService.dto.CourseDTO;
import com.example.courseService.model.CourseModel;
import com.example.courseService.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/course")
public class CourseController {
  @Autowired
  CourseService courseService;

  @PostMapping
  public CourseModel registerCourse(@RequestBody CourseModel courseModel) {
    return courseService.registerCourse(courseModel);
  }

  @GetMapping
  public List<CourseDTO> findAllCourses() {
    List<CourseModel> course = courseService.findAllCourses();
    List<CourseDTO> courseDTO = new ArrayList<>();

    for(CourseModel courses: course) {
      CourseDTO dto = new CourseDTO();
      dto.setName(courses.getName());
      dto.setWorkload(courses.getWorkload());
      courseDTO.add(dto);
    }
    return courseDTO;
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
    Optional<CourseModel> optionalCourse = courseService.findOneCourse(id);
    if(optionalCourse.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado!");
    }

    courseService.deleteCourse(id);
    return null;
  }
}
