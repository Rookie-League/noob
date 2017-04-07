package com.ohohoho.noob.module.authority.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.ohohoho.noob.module.authority.domain.Account;
import com.ohohoho.noob.module.authority.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Shiro测试Controller
 *
 * @author 单红宇(365384722)
 * @myblog http://blog.csdn.net/catoop/
 * @create 2016年1月13日
 */
@Controller
public class AuthorizeController {

    private static final Logger logger = LoggerFactory.getLogger(AuthorizeController.class);

    @Resource
    private AccountService accountService;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String testAuthority(@Valid Account account) {
        return " ";
    }

}
