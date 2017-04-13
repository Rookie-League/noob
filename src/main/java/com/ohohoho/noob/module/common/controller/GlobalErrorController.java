package com.ohohoho.noob.module.common.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping
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
    public void error(HttpServletRequest request, HttpServletResponse response) throws Exception {
        switch (response.getStatus()) {
            case FORBIDDEN:
                request.getRequestDispatcher("/403.html").forward(request, response);
                break;
            case NOT_FOUND:
                request.getRequestDispatcher("/404.html").forward(request, response);
                break;
            case INTERNAL_SERVER_ERROR:
                request.getRequestDispatcher("/500.html").forward(request, response);
                break;
        }
    }
}
