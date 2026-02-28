package uaedunung.se.config;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.ServletContext;

import java.io.File;
import java.io.IOException;

public class FreeMarkerConfig {

    private static Configuration cfg;

    public static Configuration getConfig(ServletContext servletContext) throws IOException {

        if (cfg == null) {
            cfg = new Configuration(Configuration.VERSION_2_3_31);

            String templatePath = servletContext.getRealPath("/WEB-INF/templates/");
            System.out.println("FreeMarker templates path: " + templatePath);

            if (templatePath != null) {
                cfg.setDirectoryForTemplateLoading(new File(templatePath));
            } else {
                System.out.println("⚠️ servletContext.getRealPath('/WEB-INF/templates/') повернув null!");
            }

            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        }

        return cfg;
    }
}