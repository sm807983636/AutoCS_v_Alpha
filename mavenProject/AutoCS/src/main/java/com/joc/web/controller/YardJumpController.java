package com.joc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/yard")
public class YardJumpController extends BaseController {

    @RequestMapping("/main")
    public ModelAndView yardMain(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("yard/yardMain");
    }

    @RequestMapping("/user")
    public ModelAndView yardUser(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("yard/yardUser");
    }

    @RequestMapping("/course")
    public ModelAndView yardCourse(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("yard/yardCourse");
    }

    @RequestMapping("/history")
    public ModelAndView yardHistory(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("yard/yardHistory");
    }
}
