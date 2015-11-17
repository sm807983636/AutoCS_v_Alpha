package com.joc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/teacher")
public class TeacherJumpController extends BaseController {

    @RequestMapping("/main")
    public ModelAndView teacherMain(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("teacher/teacherMain");
    }

    @RequestMapping("/course")
    public ModelAndView teacherCourse(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("teacher/teacherCourse");
    }

    @RequestMapping("/result")
    public ModelAndView teacherResult(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("teacher/teacherResult");
    }
}
