/*1.Заполнение двумерного массива значениями индекса(от 1 и до кол-ва элементов в массиве), при этом каждая вторая строка - отрицательными значениями.
        Например
        1 2 3
        -4 -5 -6
        7 8 9
        -10 -11 -12
        *Передать массив в метод, заполнить данный массив         Требования к задачам:
        А) выведение массива в консоль до/после операций над массивом (если был пустой – не нужно)
        Б) Все расчеты проводить в отдельных методах и возвращать значение, которое выводится в консоль в методе main().
        В) Исходный массив не должен измениться, т.е. создаем копию и работаем с ней, если требуется изменение массива.*/

package selfEducation.lesson5;

public class Lesson5_1 {
    public static void main(String[] args) {
        int s = 8;
        int r = 8;
        int[][] array = new int[s][r];
        for (int i = 0; i < fillArray(array).length; i++) {
            for (int j = 0; j < fillArray(array)[i].length; j++) {
                System.out.print(fillArray(array)[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] fillArray(int[][] array) {
        int num = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j =0; j < array[i].length; j++) {
                array[i][j] = num++;
                if (i % 2 != 0) {
                    array[i][j] = -array[i][j];
                }
            }
        }
        return array;
    }
}
