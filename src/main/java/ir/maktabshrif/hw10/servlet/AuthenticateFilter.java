package ir.maktabshrif.hw10.servlet;

import ir.maktabshrif.hw10.dto.UserDTO;
import ir.maktabshrif.hw10.service.UserService;
import ir.maktabshrif.hw10.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

public class AuthenticateFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();

        if (username != null && password != null) {

                servletRequest.setAttribute("message", "username and password is incorrect");
                servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                filterChain.doFilter(servletRequest, servletResponse);

        } else {
            Optional<Object> usernameOp = Optional.ofNullable(session.getAttribute("username"));
            Optional<Object> passwordOp = Optional.ofNullable(session.getAttribute("password"));
            if (usernameOp.isPresent() && passwordOp.isPresent()) {

                    filterChain.doFilter(servletRequest, servletResponse);
            } else {
                servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
            }
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
