package com.ohohoho.noob.config;

import com.earphone.common.constant.Charset;
import com.earphone.wrapper.aspect.ResultWrapAspect;
import com.ohohoho.noob.interceptor.RequestLogInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by YaoJiamin on 2016/12/9.
 */
@Configuration
public class WebServletConfig extends WebMvcConfigurerAdapter {
    private final Logger logger = LoggerFactory.getLogger(WebServletConfig.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestLogInterceptor());
        super.addInterceptors(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    @Bean
    public ResultWrapAspect resultWrapAspect() {
        logger.info("####################Initial ResultWrapAspect####################");
        return new ResultWrapAspect();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        logger.info("####################Initial CharacterEncodingFilter####################");
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new CharacterEncodingFilter(Charset.UTF_8.getCharset(), true));
        registrationBean.setMatchAfter(false);
        registrationBean.addUrlPatterns("/");
        return registrationBean;
    }

}
