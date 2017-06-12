package com.ohohoho.noob.module.wechat.controller;

import com.earphone.wrapper.annotation.LogPoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/6/12
 * @createTime 8:52
 */
@RestController
@RequestMapping("/wechat")
public class CallbackValidateController {

    @LogPoint(wrapped = false)
    @RequestMapping(method = RequestMethod.GET)
    public String validation() {
        return "";
    }

    @LogPoint(wrapped = false)
    @RequestMapping(method = RequestMethod.POST)
    public String handler() {
        return "";
    }

}
