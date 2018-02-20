package com.ohohoho.noob.config.db;

import lombok.Getter;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/8/4
 * @createTime 9:48
 */
public enum DruidDataSourceEnvironment {
    HOST("noob.jdbc.host"), PORT("noob.jdbc.port"), DB("noob.jdbc.db"), USERNAME("noob.jdbc.username"), PASSWORD("noob.jdbc.password");
    @Getter
    private String value;

    DruidDataSourceEnvironment(String key) {
        this.value = System.getenv(key);
    }

    public static String getUrl() {
        return "jdbc:mysql://" + HOST.getValue() + ":" + PORT.getValue() + "/" + DB.getValue() + "?" + "useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=round";
    }
}
