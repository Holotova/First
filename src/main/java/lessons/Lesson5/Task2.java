package lessons.Lesson5;

import java.util.Arrays;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        int[] goods = new int[12];
        valueGoods(goods);
        costOfGoods(goods);
    }
    public static void valueGoods(int[] goods){
        Random random = new Random();
        for (int i = 0; i< goods.length; i++){
            goods[i] = random.nextInt(2000);
    }
        System.out.println(Arrays.toString(goods));
}

    public static void costOfGoods(int[] goods) {
        int cost = 0;
        for (int i = 0; i< goods.length; i++){
           if (goods[i]>1000){
                cost += goods[i];
            }
        }
        System.out.println(cost);
    }



}
