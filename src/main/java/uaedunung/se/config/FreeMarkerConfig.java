package uaedunung.se.config;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

public class FreeMarkerConfig {

    private static Configuration cfg;

    public static Configuration getConfig() {
        if (cfg == null) {
            cfg = new Configuration(Configuration.VERSION_2_3_31);
            cfg.setClassLoaderForTemplateLoading(
                    FreeMarkerConfig.class.getClassLoader(), "templates");
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        }
        return cfg;
    }
}