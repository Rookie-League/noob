package com.ohohoho.noob.module.wechat.controller;

import com.earphone.common.utils.Signature;
import com.earphone.common.utils.StringExtend;
import com.earphone.common.validation.Assert;
import com.earphone.wrapper.WrapPoint;
import com.ohohoho.noob.module.wechat.request.WechatValidationRequest;
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
    private static final String token = "87cd1ff404bb416fa49ad54406199f95";

    @WrapPoint(wrapped = false)
    @RequestMapping(method = RequestMethod.GET)
    public String validation(WechatValidationRequest request) {
        Assert.wrapBoolean(request.validate()).isTrue("Wechat parameters missing!!!");
        String text = request.getParameterString(token);
        String encryptString = Signature.sha1(text);
        Boolean result = StringExtend.equals(request.getSignature(), encryptString);
        Assert.wrapBoolean(result).isTrue(" inconsistent!!!");
        return request.getEchostr();
    }

    @WrapPoint(wrapped = false)
    @RequestMapping(method = RequestMethod.POST)
    public String handler() {
        return "";
    }
}
