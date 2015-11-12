package com.joc.web.controller;

import com.joc.cons.CommonConstant;
import com.joc.domain.Departmanagement;
import com.joc.domain.Teacher;
import com.joc.domain.Yardmanagement;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;

/**
 * 所有Controller的基类
 * </pre>
 * @see
 */
public class BaseController {
    protected static final String ERROR_MSG_KEY = "errorMsg";

//    /**
//     * 获取保存在Session中的用户对象
//     *
//     * @param request
//     * @return
//     */
//    protected Teacher getSessionUser(HttpServletRequest request) {
//        return (Teacher) request.getSession().getAttribute(
//                CommonConstant.USER_CONTEXT);
//    }
//
//    protected Departmanagement getSessionUser(HttpServletRequest request) {
//        return (Departmanagement) request.getSession().getAttribute(
//                CommonConstant.USER_CONTEXT);
//    }
//
//    protected Yardmanagement getSessionUser(HttpServletRequest request) {
//        return (Yardmanagement) request.getSession().getAttribute(
//                CommonConstant.USER_CONTEXT);
//    }
    /**
     * 保存用户对象到Session中
     * @param request
     * @param user
     */
    protected void setSessionUser(HttpServletRequest request,Yardmanagement yardmanagement) {
        request.getSession().setAttribute(CommonConstant.USER_CONTEXT,
                yardmanagement);
    }
    protected void setSessionUser(HttpServletRequest request,Departmanagement departmanagement) {
        request.getSession().setAttribute(CommonConstant.USER_CONTEXT,
                departmanagement);
    }
    protected void setSessionUser(HttpServletRequest request,Teacher teacher) {
        request.getSession().setAttribute(CommonConstant.USER_CONTEXT,
                teacher);
    }
//    protected void setSessionUser(HttpServletRequest request,User user) {
//        request.getSession().setAttribute(CommonConstant.USER_CONTEXT,
//                user);
//    }


    /**
     * 获取基于应用程序的url绝对路径
     *
     * @param request
     * @param url
     *            以"/"打头的URL地址
     * @return 基于应用程序的url绝对路径
     */
    public final String getAppbaseUrl(HttpServletRequest request, String url) {
        Assert.hasLength(url, "url不能为空");
        Assert.isTrue(url.startsWith("/"), "必须以/打头");
        return request.getContextPath() + url;
    }

}
