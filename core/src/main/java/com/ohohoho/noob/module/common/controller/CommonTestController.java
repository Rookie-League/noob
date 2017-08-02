package com.ohohoho.noob.module.common.controller;

import com.earphone.common.utils.JSONExtend;
import com.earphone.wrapper.annotation.LogPoint;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohohoho.noob.constant.ProjectConstant;
import com.ohohoho.noob.module.common.request.TestRequest;
import com.ohohoho.noob.module.constant.service.ConstantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/4/13
 * @createTime 11:10
 */
@RestController
@RequestMapping
public class CommonTestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ConstantService constantService;

    @RequestMapping("/test")
    @LogPoint("test")
    public Object test(TestRequest request) throws Exception {
        logger.info(new ObjectMapper().writeValueAsString(request));
        logger.info(JSONExtend.asJSON(constantService.findByKey("666")));
        logger.info(JSONExtend.asJSON(constantService.findChildrenByParentId(ProjectConstant.TOP_ID)));
        return request;
    }

}
