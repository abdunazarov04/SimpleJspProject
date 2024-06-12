package uz.isystem.servlet.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.isystem.model.Users;
import uz.isystem.repository.UserRepository;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws IOException {
        HttpSession session1 = req.getSession(false);
        String username = req.getParameter("login1");
        String password = req.getParameter("pass1");

        UserRepository ur = new UserRepository();

        Users byUsername = ur.findByUsername(username);

        session1.setAttribute("user", byUsername);

        if (byUsername != null && byUsername.getPassword().equals(password)) {
            HttpSession session = req.getSession();
            session.setMaxInactiveInterval(60 * 60 * 24);
            session.setAttribute("user", byUsername);
            resp.sendRedirect("/");
        } else {
            resp.sendRedirect("/login");
        }
    }

}
