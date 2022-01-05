package com.example.thyme.controller;

import com.example.thyme.entity.Student;
import com.example.thyme.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/")
    public String viewHomePage(Model model)
    {
        List<Student> listStudent = studentService.getAllStudents();
        model.addAttribute("word", "Hello Word");
        model.addAttribute("listStudent", listStudent);
        System.out.println("Get/");
        return "student";
    }

    @GetMapping("/new")
    public String add(Model model)
    {
        model.addAttribute("header", "Create New Student");
        model.addAttribute("student", new Student());
        return "new";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student)
    {
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable("id") Long id)
    {
        ModelAndView modelAndView = new ModelAndView("edit");

        Student student = studentService.getStudent(id);
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id)
    {
        studentService.deleteStudent(id);
        return "redirect:/";
    }
}
