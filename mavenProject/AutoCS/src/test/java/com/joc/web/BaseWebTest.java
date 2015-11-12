package com.joc.web;

import com.joc.cons.CommonConstant;
import com.joc.domain.Teacher;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.testng.annotations.BeforeClass;
import org.unitils.UnitilsTestNG;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;

@SpringApplicationContext( { "classpath:/viewspace.xml",
"file:d:/actionSpring/chapter/chapter11/src/main/webapp/WEB-INF/viewspace-servlet.xml" })
public class BaseWebTest extends UnitilsTestNG {
	
	@SpringBeanByType
	public AnnotationMethodHandlerAdapter handlerAdapter;


	//声明Request与Response模拟对象
	public MockHttpServletRequest request;
	public MockHttpServletResponse response;
	public MockHttpSession session;


	//执行测试前先初始模拟对象
	@BeforeClass
	public void before() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		session = new MockHttpSession();
        Teacher teacher = new Teacher();
        teacher.setTeacherId(1);
        teacher.setTeacherUserName("12345");
        session.setAttribute(CommonConstant.USER_CONTEXT,teacher);
        request.setSession(session);
		request.setCharacterEncoding("UTF-8");
	}

}
