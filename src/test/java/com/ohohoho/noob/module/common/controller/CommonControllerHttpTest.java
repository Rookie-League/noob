package com.ohohoho.noob.module.common.controller;

import java.net.URL;

import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.annotation.Resource;

import static org.testng.Assert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CommonControllerHttpTest extends AbstractTestNGSpringContextTests {

    @Resource
    private TestRestTemplate template;

    @LocalServerPort
    private int port;

    private URL base;

    @BeforeMethod
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void testCommon() throws Exception {
        assertEquals(template.getForEntity(base.toString(), String.class).getBody(), "GET");
    }
}
