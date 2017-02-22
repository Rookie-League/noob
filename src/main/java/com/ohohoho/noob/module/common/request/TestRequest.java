package com.ohohoho.noob.module.common.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/2/21
 * @createTime 14:48
 */
public class TestRequest {

    @JsonProperty("json_field")
    private String jsonField;

    public String getJsonField() {
        return jsonField;
    }

    public void setJsonField(String jsonField) {
        this.jsonField = jsonField;
    }

}
