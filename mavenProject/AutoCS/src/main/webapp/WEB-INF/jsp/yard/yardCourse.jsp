<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <style type="text/css">
        #header{width: 100%;}/*设置满屏宽度*/
        /*设置顶部栏效果*/
        #info{height: 30px;background-color:#CCC;text-align:right;padding-top:5px;}
        #info a:hover{color:#FFF;}
        #nav-search{padding:5px 0 0 0;height: 30px;background-color:#9CF;}
        #nav{height: 30px;background-color:#9CF;float: left;}
        /*设置字体样式*/
        #nav a{font-size:14px;display:block; float:left; margin-left:20px; margin-top:6px;color:#fff;letter-spacing:0.2em;
            text-align:center;text-decoration:none;}
        #nav a:hover{color:#d00;
            background:#fff;}
        /*搜索框*/
        #search{height: 30px;background-color:#9CF;float: right;}
        /*系统名称效果*/
        #logo{padding: 10px 0 0 0; text-align: center; height: 50px;background-color:#69C;font-size: 40px;font-family:"隶书";color:#FFC;}
        /*系名称栏设置*/
        #major{width:15%;height:400px;padding:25px 0 0 0;text-align:center;background-color:#EAEAEA;float:left;margin: auto;border: 1px         solid #cccccc;}
        #major a{font-size:16px;}
        #major a:hover{color:#F06;}
        /*设置按钮安放位置*/
        #button1{width:40%;height:50px;padding:10px 0 0 50px;text-align:left;float:left;margin:auto;}
        #button1 input{margin-left:50px;}
        #button2{width:60%;height:50px;padding:10px 0 0 50px;text-align:left;float:left;margin:auto;border-top:2px solid #9FF;}
        #button2 input{margin-left:50px;}
        /*暂时放空的地方*/
        #sth{width:60%;height:60px;padding:10px 0 0 50px;text-align:left;float:left;margin:auto;}
        #sth a{font-size:20px;font-family:Arial;padding:10px 100px 0 0;}
        /*放置时间选择框*/
        #time{width:30%;height:250px;padding:10px 0 0 50px;text-align:left;float:left;margin:auto;}
        #time1{width:20%;height:100px;padding:10px 0 0 50px;text-align:left;float:left;margin:auto;}
        #form{padding:20px 0 0 0;margin:0px;font-size:14px;}
        /*#time2{width:20%;height:100px;text-align:left;margin-top:150px;float:left;border:2px solid #9FF;}*/
    </style>
    <title>教学办之报课管理</title>
</head>
<body>
<div id="header">
    <%@ include file="yardTop.jsp"%>
    <div id="major">
        <a href="#">计算机科学与技术</a><br/><br/>
        <a href="#">数          学</a><br/><br/>
        <a href="#">信  息  安   全</a><br/><br/>
        <a href="#">软  件  工   程</a><br/><br/>
        <a href="#">计 算 机 实 验 班</a><br/><br/>
        <a href="#">数 学  实 验 班 </a><br/><br/>
        <a href="#">数 理  综 合 班</a><br/><br/>
    </div>
    <div id=button1>
        <input type="submit" name="button" value="开始报课"/>
        &nbsp;<input type="submit" name="button" value="查看报课"/>
    </div>
    <div id=button2>
        <input type="submit" name="button" value="导入课表"/>
        <input type="submit" name="button" value="导入预览"/>
        <input type="submit" name="button" value="确定"/>
    </div>
    <div id=sth>
        <img src="http://t04.pic.sogou.com/02180dee779e8a8c-c6d81a1366188f77-b687d8000eb0132f4db7ec0ce3773c39.jpg" width="70"
             height="70"/>
        <a>开始/截止报课设置</a>
    </div>
    <div id=time>
        <form id="form">
            <label>开始报课：<input name="bk" type="date"/></label><br/><br/>
            <label>截止报课：<input name="bk" type="date"/></label><br/><br/>
            <label>开始审核：<input name="bk" type="date"/></label><br/><br/>
            <label>审核截止：<input name="bk" type="date"/></label><br/><br/>
        </form>
        <input  type="submit" value="确定"/>&nbsp;&nbsp;
        <input type="reset" value="重置"/>
    </div>
    <div id=time1>
        <img src="http://t03.pic.sogou.com/02180dee779e8a8c-9a2dfd51a14e3358-3bc24e914a3291e6ecba8a76c5e5bac1.jpg"/>
    </div>

</div>
</body>
</html>
