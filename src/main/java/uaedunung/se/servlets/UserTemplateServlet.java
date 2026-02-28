package uaedunung.se.servlets;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import uaedunung.se.config.FreeMarkerConfig;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user-template")
public class UserTemplateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html; charset=UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        Map<String, Object> model = new HashMap<>();
        model.put("name", name);
        model.put("email", email);

        Template template = FreeMarkerConfig.getConfig().getTemplate("user.ftl");

        try {
            template.process(model, response.getWriter());
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}