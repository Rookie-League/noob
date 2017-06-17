package com.ohohoho.noob.module.wechat.request;

import com.earphone.common.utils.StringUtils;

import java.util.Arrays;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/6/12
 * @createTime 11:09
 */
public class WechatValidationRequest {
    private String signature;
    private String echostr;
    private String nonce;
    private String timestamp;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getParameterString(String token) {
        String[] encryptArgs = {token, timestamp, nonce};
        Arrays.sort(encryptArgs);
        return StringUtils.join(encryptArgs, "");
    }

    public Boolean validate() {
        return StringUtils.isBlank(signature) || StringUtils.isBlank(nonce) || StringUtils.isBlank(timestamp) ? Boolean.FALSE : Boolean.TRUE;
    }
}
