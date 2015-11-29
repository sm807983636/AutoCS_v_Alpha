package com.joc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/depart")
//@SessionAttributes("loginDepart")
public class DepartJumpController extends BaseController {

    @RequestMapping("/main")
    public String departMain(HttpServletRequest request, HttpServletResponse response){
        return "depart/departMain";
    }

    @RequestMapping("/course")
    public String departCourse(HttpServletRequest request, HttpServletResponse response){
        return "depart/departCourse";
    }

    @RequestMapping("/summary")
    public String departSummary(HttpServletRequest request, HttpServletResponse response){
        return "depart/departSummary";
    }

}
