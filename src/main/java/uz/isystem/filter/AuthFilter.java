package uz.isystem.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.isystem.model.Users;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;


        List<String> lines = Files.readAllLines(Path.of("/Users/macbookair/code/SimpleJspProject/src/main/resources/whitelist.txt"));



        String uri = request.getRequestURI();

        long count = lines.stream().filter(uri::equals).count();

        if (count == 0) {
            HttpSession session = request.getSession(false);
            if (session != null) {

                Users user = (Users) session.getAttribute("user");

                if (user != null) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    response.sendRedirect("/login");
                }

            }else {
                request.getRequestDispatcher("/views/fPage.jsp").forward(request, response);
            }
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }
}
