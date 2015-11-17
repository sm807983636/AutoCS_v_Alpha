package com.joc.web.controller;

import com.joc.cons.CommonConstant;
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
import javax.servlet.http.HttpSession;

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
        String userType = request.getParameter("userType");
        if(userType.equals("1")) {
            Yardmanagement yardmanagement = yardmanagementService.queryUserByUserName(userName);
            if (yardmanagement == null) {
                request.setAttribute("errorMsg", "用户名不存在");
                return new ModelAndView("forward:/WEB-INF/jsp/login.jsp");
            } else if (!yardmanagement.getYardPassword().equals(password)) {
                request.setAttribute("errorMsg", "用户密码不正确");
                return new ModelAndView("forward:/WEB-INF/jsp/login.jsp");
            } else {
                setSessionUser(request, yardmanagement);
                ModelAndView mav = new ModelAndView("yard/yardMain");
                mav.addObject(yardmanagement);
                return mav;
            }
        }
        else if(userType.equals("2")) {
            Departmanagement departmanagement = departmanagementService.queryUserByUserName(userName);
            if (departmanagement == null) {
                request.setAttribute("errorMsg", "用户名不存在");
                return new ModelAndView("forward:/WEB-INF/jsp/login.jsp");
            } else if (!departmanagement.getDepartPassword().equals(password)) {
                request.setAttribute("errorMsg", "用户密码不正确");
                return new ModelAndView("forward:/WEB-INF/jsp/login.jsp");
            } else {
                setSessionUser(request, departmanagement);
                ModelAndView mav = new ModelAndView("depart/departMain");
                mav.addObject(departmanagement);
                return mav;
            }
        }
        else {
            Teacher teacher = teacherService.queryUserByUserName(userName);
            if (teacher == null) {
                request.setAttribute("errorMsg", "用户名不存在");
                return new ModelAndView("forward:/WEB-INF/jsp/login.jsp");
            } else if (!teacher.getTeacherPassword().equals(password)) {
                request.setAttribute("errorMsg", "用户密码不正确");
                return new ModelAndView("forward:/WEB-INF/jsp/login.jsp");
            } else {
                setSessionUser(request, teacher);
                ModelAndView mav = new ModelAndView("teacher/teacherMain");
                mav.addObject(teacher);
                return mav;
            }
        }

//        Yardmanagement yardmanagement = yardmanagementService.findUserByUserName(userName);
//        Departmanagement departmanagement = departmanagementService.findUserByUserName(userName);
//        Teacher teacher = teacherService.findUserByUserName(userName);
//        if (yardmanagement == null) {
//            if (departmanagement == null) {
//                if (teacher == null) {
//                    request.setAttribute("errorMsg", "用户名不存在");
//                    return new ModelAndView("forward:/WEB-INF/jsp/login.jsp");
//                } else if (!teacher.getTeacherPassword().equals(password)) {
//                    request.setAttribute("errorMsg", "用户密码不正确");
//                    return new ModelAndView("forward:/WEB-INF/jsp/login.jsp");
//                } else {
//                    setSessionUser(request, teacher);
//                    userType = 3;
//                }
//            } else if (!departmanagement.getDepartPassword().equals(password)) {
//                request.setAttribute("errorMsg", "用户密码不正确");
//                return new ModelAndView("forward:/WEB-INF/jsp/login.jsp");
//            } else {
//                setSessionUser(request, departmanagement);
//                userType = 2;
//            }
//        } else if (!yardmanagement.getYardPassword().equals(password)) {
//            request.setAttribute("errorMsg", "用户密码不正确");
//            return new ModelAndView("forward:/WEB-INF/jsp/login.jsp");
//        } else {
//            setSessionUser(request, yardmanagement);
//            userType = 1;
//        }
//        switch (userType){
//            case 1: {
//                ModelAndView mav = new ModelAndView("success1");
//                mav.addObject(yardmanagement);
//                return mav;
//            }
//            case 2: {
//                ModelAndView mav = new ModelAndView("success2");
//                mav.addObject(departmanagement);
//                return mav;
//            }
//            case 3:{
//                ModelAndView mav = new ModelAndView("success3");
//                mav.addObject(teacher);
//                return mav;
//            }
//            default: return new ModelAndView("fail");
//        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute(CommonConstant.USER_CONTEXT);
        return "forward:/index.jsp";
    }

    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("login");
    }
}
