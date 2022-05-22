package ua.holotova.secondModule.model;

public class DefectStringException extends Exception {
    public DefectStringException(String message) {
        super(message);
    }
    //исключение которое будет говорить о прочтении некорректной строки
}
