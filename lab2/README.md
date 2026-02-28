# Лабораторна робота №2 — Шаблонізатор FreeMarker

## Мета
- Ознайомитися з шаблонізатором FreeMarker.
- Навчитися передавати дані з сервлета у шаблон.
- Реалізувати MVC-підхід у Java Web.
- Рендерити HTML через `.ftl` файли.

## Реалізація
- Додано залежність FreeMarker у `pom.xml`.
- Створено конфігурацію `FreeMarkerConfig`.
- Створено шаблон `templates/user.ftl`.
- Створено сервлет `UserTemplateServlet`, який передає дані у шаблон.
- Рендеринг HTML через FreeMarker.

## Запуск
```bash
mvn clean package
mvn tomcat7:run

URL:http://localhost:9090/fruitsshop/user-template?name=Ira&email=ira@example.com
