package com.geekbrains.geekspring.controllers;

import com.geekbrains.geekspring.entities.Course;
import com.geekbrains.geekspring.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/crsrst/**")
@RestController
public class CourseRESTController {

    private CoursesService courseService;

    @Autowired
    public void setCourseService(CoursesService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourseById(@PathVariable Long courseId){
        return courseService.getCourseById(courseId);
    }

    @GetMapping("/courses")
    public List<Course> getCourseById(){
        return courseService.getAllCoursesList();
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        course.setId(0L);
        return courseService.save(course);
    }

    @PutMapping(path = "/courses", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Course updateCourse(@RequestBody Course course){
        course = courseService.save(course);
        return course;
    }

    @DeleteMapping("/courses/{courseId}")
    public int deleteCourse(@PathVariable Long courseId){
        courseService.delete(courseId);
        return HttpStatus.OK.value();
    }
}
