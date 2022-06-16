/*
Создать класс Lock с конструктором который принимает массив. Добавить в него метод геттер. Сделать так, чтобы массив помещенный в класс невозможно было изменить.
*/
package ua.holotova.hw8Test1;

import java.util.Arrays;
import java.util.List;

public class Test1Additional {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        Lock lock = new Lock(array);
        lock.printArray();
        int[] arr = lock.getArray();
        arr[1] = 10;
        lock.printArray();
    }
}
class Lock {
    int[] array;

    public Lock(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void printArray (){
        System.out.println((new List[]{Arrays.asList(array)}));
    }
}




