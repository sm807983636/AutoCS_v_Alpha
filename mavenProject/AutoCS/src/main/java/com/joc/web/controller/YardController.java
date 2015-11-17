package com.joc.web.controller;

import com.joc.domain.Teacher;
import com.joc.service.YardmanagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/yard")
public class YardController extends BaseController {
    @Autowired
    private YardmanagementService yardmanagementService;

    @RequestMapping("/user/add")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse response){
        String userName = request.getParameter("userName");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if(userName.isEmpty() || name.isEmpty() || password.isEmpty()) {
            request.setAttribute("errorMsg1", "不能为空");
            return new ModelAndView("forward:/WEB-INF/jsp/yard/yardUser.jsp");
        }
        else if (yardmanagementService.queryTeacherUserByTeacherUserName(userName) != null){
            request.setAttribute("errorMsg1", "该用户已存在");
            return new ModelAndView("forward:/WEB-INF/jsp/yard/yardUser.jsp");
        }
        else {
            Teacher teacher = new Teacher();
            teacher.setTeacherUserName(userName);
            teacher.setTeacherName(name);
            teacher.setTeacherPassword(password);
            yardmanagementService.saveTeacherUser(teacher);
            return new ModelAndView("yard/yardSuccess");
        }
    }
    @RequestMapping(value = "/user/find")
    public ModelAndView find(HttpServletRequest request, HttpServletResponse response){
        String department = request.getParameter("department");
        String userName = request.getParameter("userName");
        if(department.isEmpty() && userName.isEmpty()){
            request.setAttribute("errorMsg2", "不能为空");
            return new ModelAndView("forward:/WEB-INF/jsp/yard/yardUser.jsp");
        }
        String[] param = {department, userName};
        List<Teacher> teachers = yardmanagementService.queryTeacherUserByMoreConditions(param);
        if(teachers.isEmpty()){
            request.setAttribute("resultMsg1", "没有符合条件的教师");
        }
        request.setAttribute("teacher", teachers);
        ModelAndView mav = new ModelAndView("forward:/WEB-INF/jsp/yard/yardUser.jsp");
        mav.addObject(teachers);
        return mav;
    }

//    // 打开更改教师页面
//    @RequestMapping(value="/yard/{id}/edit")
//    public String updateViewSpacePage(@PathVariable Integer id,HttpServletRequest request) {
//        ViewSpace viewSpace = viewSpaceService.getFullViewSpace(id);
//        request.setAttribute("viewSpace", viewSpace);
//        return "/updateViewSpace";
//    }

    // 删除教师信息
    @RequestMapping(value="/user/{id}/delete",method= RequestMethod.DELETE)
    public String deleteViewSpace(@PathVariable Integer id) {
        yardmanagementService.removeTeacher(id);
        String targetUrl = "/yard/user.html";
        return "redirect:"+targetUrl;
    }
}
