package edu.poly.interceptor;

import edu.poly.constant.SessionAttr;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminAuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(session.getAttribute(SessionAttr.CURRENT_USER) != null) {
            return true;
        }
        session.setAttribute("customer", request.getRequestURI());
        response.sendRedirect("/account/login");

        return false;
    }
}
