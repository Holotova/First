//написать тесты

package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ua.holotova.hw4.Task4;

class CarFactoryTest {
    private CarFactory target;
    private PersonFactory personFactory;
    public Person person;

    @BeforeEach
    void setUp() {
        target = new CarFactory();
        personFactory = Mockito.mock(PersonFactory.class);
        person = new Person(20, "Person");

        Mockito.when(personFactory.createPerson()).thenReturn(person);
    }

    @Test
    void createCar_allFine() {
        final Car car = target.createCar(2, 1, "Black", personFactory);
        Assertions.assertNotNull(car);
        Assertions.assertEquals("Black", car.getColor());
        Assertions.assertEquals(1, car.getVersion());
        Assertions.assertEquals(2, car.getPersons().length);
    }

    @Test
    void createCar_createNull() {    //проверка первого ифа
        final Car car1 = target.createCar(2, 0, "Black", personFactory);
        Assertions.assertNull(car1);

        final Car car2 = target.createCar(2, -1, "Black", personFactory);
        Assertions.assertNull(car2);
    }

    @Test
    void createCar_moreThen4() { //проверка второго ифа
        final Car car = target.createCar(10, 1, "Black", personFactory);
        Assertions.assertEquals(4, car.getPersons().length);
    }

    @Test
    void createCar_lessThen0() {
        final Car car = target.createCar(-1, 1, "Black", personFactory);
        Assertions.assertEquals(0, car.getPersons().length);   //проверка второго ифа
    }

    @Test
    void createCar_checkPersonInfo() {  //только когда создается метод мокито сможем использовать проверку. Проверить то что они действительно создаются.
        final Car car = target.createCar(1, 1, "Black", personFactory);
        Assertions.assertEquals(1, car.getPersons().length);
        final Person person = car.getPersons()[0];
        Assertions.assertEquals(20, person.getAge());
        Assertions.assertEquals("Person", person.getName());
    }

    static class Task4Test {

        @Test
        void creatingArray () {
            int numbers[] = new int[2000];
            Assertions.assertNotNull(numbers);
            Assertions.assertEquals(2000, numbers.length);
        }
        @Test
        void changeEvenElementsArray () {
            int[] array = {1, 2, 3, 4, 5, 6};
            Assertions.assertArrayEquals(new int[]{1, 0, 3, 0, 5, 0}, Task4.changeEven(array));

        }
    }
}

    