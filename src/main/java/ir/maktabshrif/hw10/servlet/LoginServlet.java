package ir.maktabshrif.hw10.servlet;

import ir.maktabshrif.hw10.dto.UserDTO;
import ir.maktabshrif.hw10.model.User;
import ir.maktabshrif.hw10.service.UserService;
import ir.maktabshrif.hw10.service.UserServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDTO userDTO = userService.login(username, password).orElse(null);

        if (userDTO == null) {
            req.setAttribute("message", "Invalid username or password.");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
//            req.getSession().setAttribute("Error","Invalid username or password");
//            resp.sendRedirect(req.getContextPath() + "/notAuthorized.jsp");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("username", userDTO.getUsername());
            resp.sendRedirect(req.getContextPath() + "/dashboard.jsp");
        }
    }

}
