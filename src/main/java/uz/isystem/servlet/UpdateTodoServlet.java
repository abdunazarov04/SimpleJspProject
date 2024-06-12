package uz.isystem.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.isystem.model.ToDo;
import uz.isystem.repository.ToDoRepository;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/edit-todo")
public class UpdateTodoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        if (id != null && !id.isEmpty()) {
            try {
                int todoId = Integer.parseInt(id);
                ToDo toDo = new ToDoRepository().getOne(todoId);
                if (toDo != null) {
                    req.setAttribute("todo", toDo);
                } else {
                    req.setAttribute("error", "ToDo with ID " + id + " not found");
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                req.setAttribute("error", "Error fetching ToDo with ID " + id);
            }
        } else {
            req.setAttribute("error", "ID parameter is missing");
        }

        req.getRequestDispatcher("/views/edit-todo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String message = req.getParameter("message");
        String isDone = req.getParameter("isDone");

        if (id == null || id.isEmpty() || message == null || message.isEmpty() || isDone == null || isDone.isEmpty()) {
            req.setAttribute("error", "ID, message, and isDone parameters are required");
            req.getRequestDispatcher("/views/error.jsp").forward(req, resp);
            return;
        }

        try {
            int todoId = Integer.parseInt(id);
            ToDo toDo = new ToDoRepository().getOne(todoId);
            if (toDo != null) {
                toDo.setMessage(message);
                toDo.setIsDone(isDone);
                new ToDoRepository().update(toDo);
                resp.sendRedirect("/todo");
            } else {
                req.setAttribute("error", "ToDo with ID " + id + " not found");
                req.getRequestDispatcher("/views/error.jsp").forward(req, resp);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            req.setAttribute("error", "Invalid ID format: " + id);
            req.getRequestDispatcher("/views/error.jsp").forward(req, resp);
        }
    }
}

