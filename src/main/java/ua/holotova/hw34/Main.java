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

package ua.holotova.hw34;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. GET/api/users?user-name={user-name}&password={password}\n" +
                "2. GET/api/books\n" +
                "3. GET/api/books?name={name}\n" +
                "4. GET/api/books?year={year}\n" +
                "5. GET/api/books?name={name}&year={year}\n" +
                "6. GET/api/books?sort=year\n" +
                "7. GET/api/authors\n" +
                "8. GET/api/authors/{id}\n" +
                "9. GET/api/authors/{id}/books\n" +
                "10. GET/api/authors/{id}/books/{id}\n" +
                "11. POST/api/books?id={id}\n" +
                "12. POST/api/authors/{id}/books?id={id}\n" +
                "13. PUT/api/authors/{id}\n" +
                "14. DELETE/api/books/{id}\n" +
                "15. POST/api/books");
    }
}
