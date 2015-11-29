package com.joc.web.controller;

import com.joc.domain.Teacher;
import com.joc.service.YardmanagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/yard")
public class YardController extends BaseController {
    @Autowired
    private YardmanagementService yardmanagementService;

    @RequestMapping("/user/add")
    public String add(HttpServletRequest request, HttpServletResponse response){
        String userName = request.getParameter("userName");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String department = request.getParameter("department");
        if(userName.isEmpty() || name.isEmpty() || password.isEmpty() || department.isEmpty()) {
            request.setAttribute("errorMsg1", "不能为空");
            return "forward:/yard/user.html";
        }
        else if (yardmanagementService.queryTeacherUserByTeacherUserName(userName) != null){
            request.setAttribute("errorMsg1", "该用户已存在");
            return "yard/yardUser";
        }
        else {
            Teacher teacher = new Teacher();
            teacher.setTeacherUserName(userName);
            teacher.setTeacherName(name);
            teacher.setTeacherPassword(password);
            teacher.setTeacherDepartment(department);
            yardmanagementService.saveTeacherUser(teacher);
            return "redirect:/yard/success.html";
        }
    }
    @RequestMapping(value = "/user/find")
    public String find(HttpServletRequest request, HttpServletResponse response){
        String department = request.getParameter("department");
        String userName = request.getParameter("userName");
        if(department.isEmpty() && userName.isEmpty()){
            request.setAttribute("errorMsg2", "不能为空");
            return "yard/yardUser";
        }
        String[] param = {department, userName, ""};
        List<Teacher> teachers = yardmanagementService.queryTeacherUserByMoreConditions(param);
        if(teachers.isEmpty()){
            request.setAttribute("resultMsg1", "没有找到符合条件的教师");
        }
        request.setAttribute("teacher", teachers);
        return "yard/yardUser";
    }

//    // 打开更改教师页面
//    @RequestMapping(value="/user/{id}/edit")
//    public String editTeacher(@PathVariable Integer id,HttpServletRequest request) {
//        Teacher teacher = yardmanagementService.queryTeacherById(id);
//        request.setAttribute("teacher", teacher);
//        return "yard/yardEdit";
//    }

    // 删除教师信息
    @RequestMapping(value="/user/{id}/delete", method = RequestMethod.DELETE)
    public String deleteTeacher(@PathVariable Integer id) {
        yardmanagementService.removeTeacher(id);
        String targetUrl = "/yard/find.html";
        return "redirect:"+targetUrl;
    }
}
