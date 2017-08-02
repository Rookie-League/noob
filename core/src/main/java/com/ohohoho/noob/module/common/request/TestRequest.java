package com.ohohoho.noob.module.common.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/2/21
 * @createTime 14:48
 */
@JsonInclude(Include.NON_NULL)
public class TestRequest {

    private String jsonField;

    public void setJson_field(String jsonField) {
        this.jsonField = jsonField;
    }

    public String getJsonField() {
        return jsonField;
    }

    public void setJsonField(String jsonField) {
        this.jsonField = jsonField;
    }

}
