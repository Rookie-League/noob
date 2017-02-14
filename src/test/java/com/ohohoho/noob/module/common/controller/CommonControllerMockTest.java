package com.ohohoho.noob.module.common.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testng.annotations.Test;

import javax.annotation.Resource;

@SpringBootTest
@AutoConfigureMockMvc
public class CommonControllerMockTest extends AbstractTestNGSpringContextTests {

    @Resource
    private MockMvc mvc;

    @Test
    public void testCommon() throws Exception {
        //模拟的时候需要有web根目录(webapp)，不然会定位到testng的jar包，导致一个警告
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON);
        mvc.perform(builder).andExpect(status().isOk()).andExpect(content().string(equalTo("GET")));
    }
}
