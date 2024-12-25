package ir.maktabshrif.hw10.servlet;

import ir.maktabshrif.hw10.dto.UserDTO;
import ir.maktabshrif.hw10.model.User;
import ir.maktabshrif.hw10.service.UserService;
import ir.maktabshrif.hw10.service.UserServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.Set;

public class SignupServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDTO userDTO = UserDTO.builder()
                .username(req.getParameter("username"))
                .password(req.getParameter("password"))
                .build();
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<UserDTO>> validate = validator.validate(userDTO);
        if (validate.isEmpty()) {
            userService.signup(userDTO);
            req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);
        } else {
            req.setAttribute("Error", validate.toArray()[0]);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}