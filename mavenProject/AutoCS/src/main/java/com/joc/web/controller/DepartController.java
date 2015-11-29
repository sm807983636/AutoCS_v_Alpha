package com.joc.web.controller;

import com.joc.domain.Teacher;
import com.joc.service.DepartmanagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/depart")
public class DepartController extends BaseController {
    @Autowired
    private DepartmanagementService departmanagementService;

    @RequestMapping("/course/find")
    public String find(HttpServletRequest request, HttpServletResponse response){
        String teacherUserName = request.getParameter("teacherUserName");
        String teacherName = request.getParameter("teacherName");
        if(teacherUserName.isEmpty() && teacherName.isEmpty()){
            request.setAttribute("errorMsg1", "不能为空");
            return "depart/departCourse";
        }
        String[] param = {"", teacherUserName, teacherName};
        List<Teacher> teachers = departmanagementService.queryTeacherUserByMoreConditions(param);
        if(teachers.isEmpty()){
            request.setAttribute("resultMsg1", "没有符合条件的教师");
        }
        else{
            request.setAttribute("teacher", teachers);
        }
        return "depart/departCourse";
    }
}
