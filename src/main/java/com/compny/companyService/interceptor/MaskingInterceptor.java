package com.compny.companyService.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.compny.companyService.constants.MaskingConstant;

@Component
public class MaskingInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String maskingHeader = request.getHeader(MaskingConstant.MASKING_HEADER);

        if ("false".equalsIgnoreCase(maskingHeader)) {
            request.setAttribute("shouldMask", false);
        } else {
            request.setAttribute("shouldMask", true);
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        request.removeAttribute("shouldMask");
    }
}
