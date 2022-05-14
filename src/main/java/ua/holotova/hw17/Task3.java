/*Задан список строк в формате даты YYYY/MM/DD, преобразовать строки в даты, проверить что присутствует хотя-бы одна дата за 2021 год.*/
package ua.holotova.hw17;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class Task3 {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        boolean isYear2021Present = Stream.of("2022/03/12", "2021/05/12", "2009/08/12", "2020/12/01", "2002/07/01")
                .map(s -> LocalDate.parse(s, formatter))
                .anyMatch(d -> d.getYear() == 2021);
        System.out.println(isYear2021Present);
    }
}
