package com.ohohoho.noob.config.db;

import lombok.Getter;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/8/4
 * @createTime 9:48
 */
public enum DruidDataSourceEnvironment {
    URL("noob.jdbc.url"), USERNAME("noob.jdbc.username"), PASSWORD("noob.jdbc.password");
    @Getter
    private String value;

    DruidDataSourceEnvironment(String key) {
        this.value = System.getenv(key);
    }
}
