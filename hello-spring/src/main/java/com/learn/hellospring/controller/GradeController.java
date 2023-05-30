package com.learn.hellospring.controller;

import com.learn.hellospring.model.Grade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GradeController {

    List<Grade> gradeList = new ArrayList<>();

    @GetMapping("/hello")
    public String sayHello() {
        return "hello-page";
    }

    @GetMapping("/grades")
    public String getGrades(Model model) {
        Grade grade = new Grade();
        grade.setName("Ish");
        grade.setSubject("potions");
        grade.setScore(5);

        model.addAttribute("grade", grade);
        model.addAttribute("someText", "Life in Harry Potter movie is real");
        return "grades";
    }

    @GetMapping("/gradeslist")
    public String getGradesList(Model model) {
        model.addAttribute("grades", gradeList);
        return "gradesList";
    }

    @GetMapping("/")
    public String gradeForm(Model model) {
        model.addAttribute("grade", new Grade());
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String addGradeForm(Grade grade, Model model) {
        gradeList.add(grade);
        return "redirect:/gradeslist";
    }
}
