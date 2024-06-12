package uz.isystem.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.isystem.model.ToDo;
import uz.isystem.repository.ToDoRepository;

import java.io.IOException;

@WebServlet("/edit-todo")
public class UpdateTodoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        ToDo one = new ToDoRepository().getOne(Integer.parseInt(id));

        req.setAttribute("todo",one);
        req.getRequestDispatcher("/views/todo.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String message = req.getParameter("message");
        String isDone = req.getParameter("isDone");
        new ToDoRepository().update(new ToDo(message, isDone));
        resp.sendRedirect("/todo");
    }
}
