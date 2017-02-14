package com.ohohoho.noob.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author yaojiamin
 * @description TODO
 * @createTime 2016-7-6 上午10:28:17
 */
public class RequestLogInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(RequestLogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        logger.info("STATUS={}#URI={}#ARGUMENTS={}", response.getStatus(), getRequestURI(request), request.getParameterMap());
        return true;
    }

    private Object getRequestURI(HttpServletRequest request) {
        Object forwardURI = request.getAttribute(RequestDispatcher.FORWARD_REQUEST_URI);
        if (Objects.nonNull(forwardURI)) return forwardURI;
        return request.getRequestURI();
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //TODO
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //TODO
    }
}
