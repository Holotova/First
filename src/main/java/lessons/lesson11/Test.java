/*создать класс конструктор работников фирмі (сторож, работник, бухгалтер, начальник)  - 4 класса
        Віделитьь абстракцию (поле зарлата). Всем дать возможность вістчитать заплтау. У каждого класса своя логика.
        Каждому дать уникальный метод (один класс пишет имя, другой значение, третий...)
        Мейн
        посчитать зарплату для всех объектов через полиморфизм
        вызвать уникальный метод у полиморфной переменной.*/

package lessons.lesson11;

public class Test {
    public static void main(String[] args) {
        Data watchman = new Watchman();
        watchman.countSalary(500, 20);

        Data worker = new Worker();
        worker.countSalary(800, 25);

        if (watchman instanceof Watchman watchman1) {
            watchman1.printName();

        } else if (worker instanceof Worker worker1) {
            worker1.printID();
        }
        System.out.println(watchman.countSalary(500, 20));
        System.out.println(worker.countSalary(800, 25));

    }

}


