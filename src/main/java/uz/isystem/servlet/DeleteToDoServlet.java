package uz.isystem.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.isystem.repository.ToDoRepository;

import java.io.IOException;

@WebServlet("/del-todo")
public class DeleteToDoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        new ToDoRepository().delete(Integer.parseInt(id));
        resp.sendRedirect("/todo");
    }
}
