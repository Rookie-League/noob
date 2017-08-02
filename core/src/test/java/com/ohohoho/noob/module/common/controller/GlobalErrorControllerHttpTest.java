package com.ohohoho.noob.module.common.controller;

import java.net.URL;

import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.annotation.Resource;

import static org.testng.Assert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GlobalErrorControllerHttpTest extends AbstractTestNGSpringContextTests {

    @Resource
    private TestRestTemplate template;

    @LocalServerPort
    private int port;

    private String base;

    @BeforeMethod
    public void setUp() throws Exception {
        this.base = "http://localhost:" + port + "/";
    }

    @Test
    public void test() throws Exception {
        assertEquals(template.getForEntity(new URL(base + "test").toString(), String.class).getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testError404() throws Exception {
        assertEquals(template.getForEntity(new URL(base + "asdfasdfsdaf").toString(), String.class).getStatusCode(), HttpStatus.NOT_FOUND);
    }

}
