package selfEducation.lesson6.klass;

public enum Manufacturer {
    VOLVO ("Вольво"),
    NISSAN ("Ниссан"),
    BMW ("БМВ");

    String russianName;

    Manufacturer(String russianName) {
        this.russianName = russianName;
    }

    @Override
    public String toString() {
        return russianName;
    }
}
