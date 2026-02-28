# Лабораторна робота №1 — Сервлети, HTTP, сесії, куки

## Мета
- Ознайомитися з сервлетами.
- Навчитися працювати з HTTP‑запитами.
- Реалізувати GET/POST.
- Використати параметри, path variables, сесії та куки.

## Реалізація
- Створено сервлет `UserServlet`.
- GET повертає HTML.
- POST повертає JSON.
- Параметри: `?name=...`
- Path variable: `/user/{id}`
- Сесія: `HttpSession`
- Кука: `Cookie`

## Запуск
```bash
mvn clean package
mvn tomcat7:run

URL: http://localhost:9090/fruitsshop/user?name=Ira
URL: http://localhost:9090/fruitsshop/user/123
