package org.example.develop.servelet;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.develop.exception.FilterLoginException;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;


public class LoginFilter implements Filter {
    private static final String[] WHITE_LIST = {"/", "/user/login","/user/signup","/user/logout"};


    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        if (!isWhiteList(requestURI)) {
            HttpSession session = httpRequest.getSession(false);
            if (session == null || session.getAttribute("userId") == null) {
                throw new FilterLoginException("로그인이 필요합니다.");
            }
        }
        chain.doFilter(request,response);
    }

    private boolean isWhiteList(String requestURI) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST,requestURI);
    }
}
