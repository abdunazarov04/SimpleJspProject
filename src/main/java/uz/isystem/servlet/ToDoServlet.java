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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/views/show-todos.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String message = req.getParameter("message");
        String isDone = req.getParameter("isDone");
        HttpSession session = req.getSession(false);
        Users users = (Users) session.getAttribute("user");

        toDoRepository.save(new ToDo(message, isDone, users));

        req.getRequestDispatcher("/views/todo.jsp").forward(req, resp);
    }
}
