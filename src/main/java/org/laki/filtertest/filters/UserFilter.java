package org.laki.filtertest.filters;

import org.springframework.core.annotation.Order;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(1)
public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String userNameHeader = req.getHeader("user-name");
        System.out.println("User name header sent by client : "+userNameHeader);
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("Loaded user name of user profile : " + user.getUsername());
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
