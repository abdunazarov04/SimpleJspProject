package uz.isystem.servlet.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.isystem.model.Users;
import uz.isystem.repository.UserRepository;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    UserRepository userRepository = new UserRepository();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        Users users = new Users(name, username, password, gender);
        if (!userRepository.exists(users)) {
            userRepository.save(users);
            resp.sendRedirect("/login");
        }else {
            req.getRequestDispatcher("/views/exists.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
    }
}
