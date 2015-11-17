<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String context = request.getContextPath();
    request.setAttribute("context",context);
%>
<div id="info">
    <a>${teacher.teacherName}教师，欢迎您!</a>&nbsp&nbsp&nbsp
    <a href="<c:url value="/logout.html"/>">退出登录</a>&nbsp
    |&nbsp <a href="<c:url value="/logout.html"/>">修改信息</a>
</div>
<div id="nav-search">
    <div id="nav">
        <a href="<c:url value="/teacher/main.html"/>">首页</a>
        <a href="<c:url value="/teacher/course.html"/>">报课</a>
    </div>
    <div id="search">

    </div>
</div>
<div id="logo">
    福州大学数计学院自动排课系统
</div>