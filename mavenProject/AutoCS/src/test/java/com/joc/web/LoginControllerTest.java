package com.joc.web;

import com.joc.web.controller.BaseController;
import org.springframework.test.web.server.MockMvc;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.server.setup.MockMvcBuilders.xmlConfigSetup;

public class LoginControllerTest extends BaseController {
    private MockMvc mockMvc;
    String appContextPath = "classpath:/applicationContext.xml";
    String webContextPath = "file:d:/Users/Administrator/IdeaProjects/AutoCS/src/main/webapp/WEB-INF/AutoCS-servlet.xml";
    String warDir = "src/main/webapp";

    @BeforeClass
    public void setUp() {
        mockMvc = xmlConfigSetup(appContextPath, webContextPath)
                .configureWebAppRootDir(warDir, false)
                .build();
    }

    @Test
    public void testDoLogin() throws Exception {
        mockMvc.perform(post("/login").param("userName", "tom").param("password", "12345"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/index.jsp"));

        mockMvc.perform(post("/login").param("userName", "123456").param("password", "12345"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/index.jsp"));

        mockMvc.perform(post("/login").param("userName", "12345").param("password", "12345"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/jsp/success.jsp"));

    }

    @Test
    public void testLogout() throws Exception {
        mockMvc.perform(get("/login/doLogout"))
                .andExpect(status().isOk())
                .andExpect(redirectedUrl("/index.jsp"));
    }

}