package uz.isystem.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.isystem.model.ToDo;
import uz.isystem.model.Users;
import uz.isystem.repository.ToDoRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/todo")
public class ToDoServlet extends HttpServlet {
    private ToDoRepository toDoRepository = new ToDoRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<ToDo> toDos = toDoRepository.getAll();
            req.setAttribute("todo", toDos);
            req.getRequestDispatcher("/views/show-todos.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to retrieve to-do items.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        String isDone = req.getParameter("isDone");

        if (message == null || isDone == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameters.");
            return;
        }

        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not logged in.");
            return;
        }

        Users users = (Users) session.getAttribute("user");
        if (users == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not logged in.");
            return;
        }

        try {
            toDoRepository.save(new ToDo(message, isDone, users));
            List<ToDo> toDos = toDoRepository.getAll();
            req.setAttribute("todo", toDos);
            req.getRequestDispatcher("/views/show-todos.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to save to-do item.");
        }
    }
}

