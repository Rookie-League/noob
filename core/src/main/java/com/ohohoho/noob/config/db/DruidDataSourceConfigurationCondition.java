package com.ohohoho.noob.config.db;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import static com.ohohoho.noob.config.db.DruidDataSourceEnvironment.PASSWORD;
import static com.ohohoho.noob.config.db.DruidDataSourceEnvironment.URL;
import static com.ohohoho.noob.config.db.DruidDataSourceEnvironment.USERNAME;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2017/8/4
 * @createTime 8:56
 */
class DruidDataSourceConfigurationCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return isNotBlank(URL.getValue()) && isNotBlank(USERNAME.getValue()) && isNotBlank(PASSWORD.getValue());
    }
}