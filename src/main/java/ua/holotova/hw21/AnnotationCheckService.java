package ua.holotova.hw21;

import lombok.SneakyThrows;
import org.reflections.Reflections;
import ua.holotova.hw21.interfaces.AutoCreate;
import ua.holotova.hw21.interfaces.Init;
import ua.holotova.hw21.interfaces.Multiplier;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationCheckService {
    final Reflections reflections = new Reflections("ua.holotova.hw21");
    final Set<Class<?>> annotatedAutoCreateClasses = reflections.getTypesAnnotatedWith(AutoCreate.class);

    @SneakyThrows
    public void changeAnnotatedClasses() {
        Map<String, Object> myPets = new HashMap<>();
        Field[] fields;
        Object exemplar;

        for (Class<?> pet : annotatedAutoCreateClasses) {
            exemplar = createExemplar(pet);
            fields = pet.getDeclaredFields();
            myPets.put(pet.getSimpleName(), exemplar);
            System.out.printf("%s before changes:\n%s \n", pet.getSimpleName(), exemplar);
            changeAnnotatedFields(fields, exemplar);
            System.out.printf("%s after changes:\n%s \n", pet.getSimpleName(), exemplar);
            System.out.println("__________________________");
        }
        callInitMethod(myPets);
    }

    @SneakyThrows
    private Object createExemplar(Class<?> pet) {
        Object pet1 = pet.getDeclaredConstructor().newInstance();
        return pet1;
    }

    @SneakyThrows
    private void changeAnnotatedFields(Field[] fields, Object object) {
        for (Field field : fields) {
            boolean isFieldInteger = field.getType().getSimpleName().equalsIgnoreCase("Integer");
            boolean isFieldDouble = field.getType().getSimpleName().equalsIgnoreCase("Double");

            if (field.isAnnotationPresent(Multiplier.class)) {
                field.setAccessible(true);
                if (readAnnotation(field).equalsIgnoreCase("addition") &&
                        checkFieldTypeNumber(field, object)) {
                    if (isFieldInteger) {
                        field.set(object, (Integer) field.get(object) + (Integer) field.get(object));
                    } else if (isFieldDouble) {
                        field.set(object, (Double) field.get(object) + (Double) field.get(object));
                    }
                } else if (readAnnotation(field).equalsIgnoreCase("multiplication") &&
                        checkFieldTypeNumber(field, object)) {
                    if (isFieldInteger) {
                        field.set(object, (Integer) field.get(object) * 3);
                    } else if (isFieldDouble) {
                        field.set(object, (Double) field.get(object) * 3);
                    }
                } else {
                    System.out.printf("Field '%s' cannot be changed. It is not Number\n", field.getName());
                }
            }
        }
    }

    @SneakyThrows
    private boolean checkFieldTypeNumber(Field field, Object object) {
        if (field.get(object) instanceof Number) {
            return true;
        } else {
            return false;
        }
    }

    private String readAnnotation(AnnotatedElement element) {
        String annotationText = "";
        Annotation[] annotations = element.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Multiplier multiplier) {
                annotationText = multiplier.operation();
            }
        }
        return annotationText;
    }

    @SneakyThrows
    private void callInitMethod(Map<String, Object> myPets) {
        System.out.println("Methods with Init: ");
        for (Object pet : myPets.values()) {
            Method[] methods = pet.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Init.class)) {
                    method.invoke(pet);
                }
            }
        }
    }
}








