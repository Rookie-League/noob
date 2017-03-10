package com.ohohoho.noob.module.common.controller;

import com.earphone.aop.annotation.LogPoint;
import com.earphone.utility.utils.JSONUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohohoho.noob.constant.BasicDataCode;
import com.ohohoho.noob.module.common.request.TestRequest;
import com.ohohoho.noob.module.constant.service.ConstantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping
public class CommonController implements ErrorController {
    private static final int NOT_FOUND = 404;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String PATH = "/error";

    @Resource
    private ConstantService constantService;

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(PATH)
    public void error(HttpServletRequest request, HttpServletResponse response) throws Exception {
        switch (response.getStatus()) {
            case NOT_FOUND:
                request.getRequestDispatcher("/404.html").forward(request, response);
                break;
            case INTERNAL_SERVER_ERROR:
                request.getRequestDispatcher("/500.html").forward(request, response);
                break;
        }
    }

    @RequestMapping("/test")
    @LogPoint("test")
    public Object test(TestRequest request) throws Exception {
        logger.info(new ObjectMapper().writeValueAsString(request));
        logger.info(JSONUtils.toJSON(constantService.findByKey("666")));
        logger.info(JSONUtils.toJSON(constantService.findChildrenByParentId(BasicDataCode.TOP_ID)));
        return request;
    }
}
