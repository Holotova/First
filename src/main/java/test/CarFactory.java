package test;

public class CarFactory {
    public  Car createCar(int personCount, int version, String color, PersonFactory personFactory) {
        if (version <= 0) {
            return  null;
        }

        if (personCount > 4){
            personCount = 4;
        }

        final Car car = new Car();
        car.setColor(color);
        car.setVersion(version);

        Person[] persons = new Person[personCount];
        for (int i = 0; i < personCount; i++) {
            persons[i] = personFactory.createPerson();
        }
        car.setPersons(persons);
        return car;
    }
}
