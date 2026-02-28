package uaedunung.se.servlets;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import uaedunung.se.config.FreeMarkerConfig;
import uaedunung.se.models.Fruit;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/add-fruit")
public class AddFruitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html; charset=UTF-8");

        Template template = FreeMarkerConfig.getConfig().getTemplate("addFruit.ftl");
        try {
            template.process(new HashMap<>(), resp.getWriter());
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        Fruit fruit = new Fruit(name, price, quantity);

        HttpSession session = req.getSession();

        @SuppressWarnings("unchecked")
        List<Fruit> fruits = (List<Fruit>) session.getAttribute("fruits");

        if (fruits == null) {
            fruits = new ArrayList<>();
        }

        fruits.add(fruit);
        session.setAttribute("fruits", fruits);

        resp.sendRedirect("/fruitsshop/fruit-list");
    }
}