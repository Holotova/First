/* Написать эндпоинты:  Сайт электронной библиотеки:
1. Войти в систему
2. Посмотреть все книги
3. Фильтровать по названию
4. Фильтровать по году
5. Фильтровать по названию и году
6. Отсортировать по году
7. Посмотреть всех авторов
8. Посмотреть конкретного автора
9. Посмотреть все книги автора
10. Посмотреть конкретную книгу автора
11. Создать новую книгу
12. Добавить книгу автору
13. Обновить автора
14. Удалить книгу
15. Создать много книг*/

package ua.holotova.hw35;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. POST/api/login\n" +
                    "body{\n" +
                    "\"user-name\":\"user-name\"\n" +
                    "\"password\":\"password\"\n" +
                    "}\n" +
                "2. GET/api/books\n" +
                "3. GET/api/books?name={name}\n" +
                "4. GET/api/books?year={year}\n" +
                "5. GET/api/books?name={name}&year={year}\n" +
                "6. GET/api/books?sort=year\n" +
                "7. GET/api/authors\n" +
                "8. GET/api/authors/{id}\n" +
                "9. GET/api/authors/{id}/books\n" +
                "10. GET/api/authors/{id}/books/{id}\n" +
                "11. POST/api/books\n" +
                    "body{\n" +
                    "\"id\":\"223423\",\n" +
                    "\"name\":\"Effective Java\",\n" +
                    "\"year\":2018,\n" +
                    "\"author\":\"Joshua Bloch\"\n" +
                    "}\n" +
                "12. POST/api/authors/{id}/books\n" +
                    "body{\n" +
                    "\"id\":\"58467598\",\n" +
                    "\"name\":\"Java for Dummies\",\n" +
                    "\"year\":2019\n" +
                    "}\n" +
                "13. PUT/api/authors/{id}\n" +
                    "body{\n" +
                    "\"author\":\"Herbert Schildt\"\n" +
                    "}\n" +
                "14. DELETE/api/books/{id}\n" +
                "15. POST/api/books\n" +
                    "body{\n" +
                    "[{\"id\":\"11111\",\n" +
                    "\"name\":\"Some book 1\",\n" +
                    "\"year\":2022,\n" +
                    "\"author\":\"Author-1\"},\n\n" +
                    "{\"id\":\"2222\",\n" +
                    "\"name\":\"Some book 2\",\n" +
                    "\"year\":2022,\n" +
                    "\"author\":\"Author-2\"},\n\n" +
                    "{\"id\":\"3333\",\n" +
                    "\"name\":\"Some book 3\",\n" +
                    "\"year\":2022,\n" +
                    "\"author\":\"Author-3\"}]" +
                    "\n}");
    }
}
