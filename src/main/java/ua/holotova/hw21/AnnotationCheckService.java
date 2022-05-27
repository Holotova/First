package ua.holotova.hw21;

import org.reflections.Reflections;
import ua.holotova.hw21.interfaces.AutoCreate;
import ua.holotova.hw21.interfaces.Init;
import ua.holotova.hw21.interfaces.Multiplier;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationCheckService {
    public static void checkAnnotatedClasses() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException{
        final Reflections reflections = new Reflections("ua.holotova.hw21");
        final Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(AutoCreate.class);

        Map<String, Object> myPets = new HashMap<>();
        for (Class<?> pet : annotatedClasses) {
            myPets.put(pet.getSimpleName(), createExemplar(pet));
            checkAnnotadedFields(pet);
        }
        System.out.println(myPets);

        for (Map.Entry<String, Object> entry : myPets.entrySet()) {
            Method[] methods = myPets.values().getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Init.class)) {
                    method.invoke(entry.getValue());
                }
            }
        }
    }
    private static Object createExemplar(Class<?> pet) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object pet1 = pet.getDeclaredConstructor().newInstance();
        return pet1;
    }
    private static void checkAnnotadedFields(Class<?> pet) throws IllegalAccessException {
        Field[] fields = pet.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Multiplier.class)) {
                if(readAnnotation(field).equalsIgnoreCase("addition")){
                    field.setAccessible(true);
                    field.set(pet, (Integer)field.get(pet)+ (Integer) field.get(pet));
                } else if(readAnnotation(field).equalsIgnoreCase("multiplication")){
                    field.setAccessible(true);
                    field.set(pet, (Integer)field.get(pet)*3);
                }
                System.out.println(field);
            }

        }
    }
    private static String readAnnotation(AnnotatedElement element){
        String annotationText = "";
        Annotation[] annotations = element.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Multiplier multiplier) {
                annotationText =  multiplier.operation();
            }
        }
        return annotationText;
    }
}








