package com.geekbrains.controllers;

import com.geekbrains.entities.Course;
import com.geekbrains.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.transaction.Transactional;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private CoursesService coursesService;

    @Autowired
    public void setCoursesService(CoursesService coursesService){
        this.coursesService = coursesService;
    }

    @RequestMapping("/list")
    @Transactional
    public String showCourses(Model uiModel){
        uiModel.addAttribute("coursesList", coursesService.getAllCoursesList());
        return "courses-list";
    }

    @RequestMapping(path="/remove/{id}", method= RequestMethod.GET)
    public String removeById(@PathVariable(value = "id") Long courseId) {
        coursesService.removeById(courseId);
        return "redirect:/courses/list";
    }

    @RequestMapping(path="/add", method=RequestMethod.GET)
    public String showAddForm(Model model) {
        Course course = new Course();
        course.setTitle("Unknown");
        model.addAttribute("course", course);
        return "add-course-form";
    }

    @RequestMapping(path="/add", method=RequestMethod.POST)
    public String showAddForm(Course course) {
        coursesService.addCourse(course);
        return "redirect:/courses/list";
    }

}
