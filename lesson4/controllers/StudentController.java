package lesson4.controllers;

import lesson4.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(path = "/add")
    @ResponseBody
    public String stAdd(){
        studentService.fillTable();
        return "added";
    }

    @RequestMapping(path = "/getAll")
    public String stGet(Model uiModel, @RequestParam(required = false, defaultValue = "0") int page){
        uiModel.addAttribute("maxStudent", studentService.getMaxScore());
        uiModel.addAttribute("minStudent", studentService.getMinScore());
        uiModel.addAttribute("students", studentService.getAll(page));
        return "students";
    }
}
