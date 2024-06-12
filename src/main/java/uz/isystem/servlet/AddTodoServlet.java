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

@WebServlet("/todos")
public class AddTodoServlet extends HttpServlet {
    private ToDoRepository toDoRepository = new ToDoRepository();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/todo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        String isDone = req.getParameter("isDone");

        if (message == null || message.trim().isEmpty() || isDone == null || isDone.trim().isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Message and isDone parameters are required.");
            return;
        }

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not logged in.");
            return;
        }

        Users users = (Users) session.getAttribute("user");

        try {
            ToDo newToDo = new ToDo();
            newToDo.setMessage(message);
            newToDo.setIsDone(isDone);
            newToDo.setUsers(users);
            toDoRepository.save(newToDo);

            List<ToDo> toDos = toDoRepository.getAll();
            req.setAttribute("todo", toDos);
            req.getRequestDispatcher("/views/show-todos.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to save to-do item.");
        }
    }
}
