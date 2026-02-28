package uaedunung.se.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/*")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Параметр ?name=Ira
        String name = request.getParameter("name");

        // Path variable /user/123
        String pathInfo = request.getPathInfo(); // /123
        String userId = (pathInfo != null && pathInfo.length() > 1)
                ? pathInfo.substring(1)
                : "no-id";

        // Сесія
        HttpSession session = request.getSession();
        session.setAttribute("lastUser", name);

        // Куки
        Cookie cookie = new Cookie("username", name != null ? name : "guest");
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);

        out.println("<h1>GET UserServlet</h1>");
        out.println("<p>Name param: " + name + "</p>");
        out.println("<p>User ID (path variable): " + userId + "</p>");
        out.println("<p>Session saved: lastUser = " + session.getAttribute("lastUser") + "</p>");
        out.println("<p>Cookie set: username</p>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json; charset=UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        String json = "{ \"name\": \"" + name + "\", \"email\": \"" + email + "\" }";

        response.getWriter().write(json);
    }
}