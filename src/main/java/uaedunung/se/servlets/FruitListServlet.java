package uaedunung.se.servlets;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import uaedunung.se.config.FreeMarkerConfig;
import uaedunung.se.models.Fruit;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/fruit-list")
public class FruitListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html; charset=UTF-8");

        HttpSession session = req.getSession();

        @SuppressWarnings("unchecked")
        List<Fruit> fruits = (List<Fruit>) session.getAttribute("fruits");

        Map<String, Object> model = new HashMap<>();
        model.put("fruits", fruits);

        Template template = FreeMarkerConfig.getConfig().getTemplate("fruitList.ftl");

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}