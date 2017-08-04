package com.ohohoho.noob.module.common.controller;

import com.earphone.wrapper.WrapPoint;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class GlobalErrorController implements ErrorController {
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final String PATH = "/error";

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(PATH)
    @WrapPoint(forceFailure = true, serialize = false)
    public Object error(HttpServletRequest request, HttpServletResponse response) throws Exception {
        switch (response.getStatus()) {
            case FORBIDDEN:
                return "No Permission";
            case NOT_FOUND:
                return "Not Found";
            case INTERNAL_SERVER_ERROR:
                return "Fatal Error";
        }
        return "System Error";
    }
}
