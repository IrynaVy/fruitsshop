package uaedunung.se.servlets;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uaedunung.se.config.FreeMarkerConfig;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        Configuration cfg = FreeMarkerConfig.getConfig(getServletContext());

        try {
            Template template = cfg.getTemplate("hello.ftl");

            Map<String, Object> model = new HashMap<>();
            model.put("message", "Привіт із FreeMarker!");

            try (Writer out = new OutputStreamWriter(resp.getOutputStream(), "UTF-8")) {
                template.process(model, out);
            }

        } catch (TemplateException e) {
            throw new ServletException("Помилка у FreeMarker", e);
        }
    }
}