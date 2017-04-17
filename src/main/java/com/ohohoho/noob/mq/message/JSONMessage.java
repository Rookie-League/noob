package com.ohohoho.noob.mq.message;

import com.earphone.common.utils.JSONUtils;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/4/17
 * @createTime 14:13
 */
public class JSONMessage {
    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return JSONUtils.toJSON(this);
    }
}
