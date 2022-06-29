package ua.holotova.hw21;

import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args){

        AnnotationCheckService service = new AnnotationCheckService();
        service.changeAnnotatedClasses();

    }
}
