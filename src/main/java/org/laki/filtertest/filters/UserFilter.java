package org.laki.filtertest.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(UserFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String userNameHeader = req.getHeader("user-name");
        logger.info("User name header sent by client : " + userNameHeader);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        logger.info("Loaded user name of user profile : " + user.getUsername());
        if (userNameHeader.equals(user.getUsername())) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
