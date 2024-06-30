package com.compny.companyService.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Component
public class MaskingInterceptor implements HandlerInterceptor {

    private static final List<String> URLS_TO_SKIP_MASKING = Arrays.asList(
            "/companies", "/companies/{id}",
            "/companies/1", "/companies/2", "/companies/3"



    );

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        System.out.println("Request URI: " + requestURI);

        if (URLS_TO_SKIP_MASKING.contains(requestURI)) {
            request.setAttribute("shouldMask", false);
        } else {
            request.setAttribute("shouldMask", true);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Optionally clear the attribute after processing
        request.removeAttribute("shouldMask");
    }
}
