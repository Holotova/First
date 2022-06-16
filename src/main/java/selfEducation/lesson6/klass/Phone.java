package selfEducation.lesson6.klass;

public class Phone {
    int number = 777;
    String model = "777";
    double weight = 777.00;

    public Phone(int number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public Phone(int number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone() {
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number=" + number +
                ", model='" + model + '\'' +
                ", weight=" + weight +
                '}';
    }

    public void receiveCall (String name){
        System.out.println("Звонит " + name);
    }

    public int getNumber(){
        return number;
    }
}
