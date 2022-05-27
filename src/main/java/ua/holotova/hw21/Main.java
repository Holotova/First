package ua.holotova.hw21;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
        AnnotationCheckService.checkAnnotatedClasses();
    }
}
