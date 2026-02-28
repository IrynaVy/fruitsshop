# Лабораторна робота №3 — Форми, POST-запити, моделі та сесії

## Мета
- Навчитися працювати з HTML-формами.
- Обробляти POST-запити у сервлетах.
- Використовувати моделі Java.
- Зберігати дані у сесії.
- Відображати дані через FreeMarker.

## Реалізація
- Створено модель `Fruit`.
- Реалізовано форму додавання фруктів (`addFruit.ftl`).
- Створено сервлет `AddFruitServlet` для обробки POST.
- Дані зберігаються у сесії.
- Створено `FruitListServlet` для показу списку.
- Відображення через шаблон `fruitList.ftl`.

## Запуск
```bash
mvn clean package
mvn tomcat7:run

URL
Додати фрукт: http://localhost:9090/fruitsshop/add-fruit
Список фруктів: http://localhost:9090/fruitsshop/fruit-list