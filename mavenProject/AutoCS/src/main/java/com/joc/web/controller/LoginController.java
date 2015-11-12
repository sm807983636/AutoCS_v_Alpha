package com.joc.web.controller;

import com.joc.domain.Departmanagement;
import com.joc.domain.Teacher;
import com.joc.domain.Yardmanagement;
import com.joc.service.DepartmanagementService;
import com.joc.service.TeacherService;
import com.joc.service.YardmanagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("")
public class LoginController extends BaseController{
    @Autowired
    private YardmanagementService yardmanagementService;
    @Autowired
    private DepartmanagementService departmanagementService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Yardmanagement yardmanagement = yardmanagementService.findUserByUserName(userName);
        Departmanagement departmanagement = departmanagementService.findUserByUserName(userName);
        Teacher teacher = teacherService.findUserByUserName(userName);
        int userType;
        if (yardmanagement == null) {
            if (departmanagement == null) {
                if (teacher == null) {
                    request.setAttribute("errorMsg", "用户名不存在");
                    return new ModelAndView("forward:/WEB-INF/jsp/login.jsp");
                } else if (!teacher.getTeacherPassword().equals(password)) {
                    request.setAttribute("errorMsg", "用户密码不正确");
                    return new ModelAndView("forward:/WEB-INF/jsp/login.jsp");
                } else {
                    setSessionUser(request, teacher);
                    userType = 3;
                }
            } else if (!departmanagement.getDepartPassword().equals(password)) {
                request.setAttribute("errorMsg", "用户密码不正确");
                return new ModelAndView("forward:/WEB-INF/jsp/login.jsp");
            } else {
                setSessionUser(request, departmanagement);
                userType = 2;
            }
        } else if (!yardmanagement.getYardPassword().equals(password)) {
            request.setAttribute("errorMsg", "用户密码不正确");
            return new ModelAndView("forward:/WEB-INF/jsp/login.jsp");
        } else {
            setSessionUser(request, yardmanagement);
            userType = 1;
        }
        switch (userType){
            case 1: return new ModelAndView("success1");
            case 2: return new ModelAndView("success2");
            case 3: return new ModelAndView("success3");
            default: return new ModelAndView("fail");
        }
    }
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("login");
    }
}
