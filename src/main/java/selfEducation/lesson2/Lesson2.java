/*2. Создать метод и вызвать его в main():
Заданы плоские декартовы координаты треугольника. Найти площадь треугольника.

3. Создать метод и вызвать его в main():
метод будет сообщать, является ли целое число, переданное в метод, чётным или нет.

4. Создать метод и вызвать его в main():
Метод будет выводить на экран меньшее по модулю из трёх переданных в метод вещественных чисел.
Для вычисления модуля используйте тернарную операцию.*/

package selfEducation.lesson2;

public class Lesson2 {
    public static void main(String[] args) {
        System.out.println("Площадь треугольника равна " + getTriangleArea(2, 1, 3, -2, -6, -3));
        System.out.println(evenOdd(5));
        System.out.println("Минимальное по модулю число " + countMinNumber(85, -47, 33));
    }

    public static Double getTriangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double area = 0.5 * ((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3));
        return Math.abs(area);
    }

    public static String evenOdd(int number) {
        if (number % 2 == 0) {
            return "Even";
        }
        return "Odd";
    }

    public static double countMinNumber(int a, int b, int c) {
        a = a >= 0 ? a : -a;
        b = b >= 0 ? b : -b;
        c = c >= 0 ? c : -c;

        double min = a < b ? a < c ? a : c : b < c ? b : c;
        return min;

    }
}
