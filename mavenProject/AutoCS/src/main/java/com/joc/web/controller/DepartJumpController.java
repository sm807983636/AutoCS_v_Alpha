package com.joc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/depart")
public class DepartJumpController extends BaseController {

    @RequestMapping("/main")
    public ModelAndView departMain(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("depart/departMain");
    }

    @RequestMapping("/course")
    public ModelAndView departCourse(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("depart/departCourse");
    }

    @RequestMapping("/summary")
    public ModelAndView departSummary(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("depart/departSummary");
    }

}
