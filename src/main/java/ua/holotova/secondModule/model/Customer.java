package ua.holotova.secondModule.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    private int id;
    private String email;
    private int age;

    @Override
    public String toString() {
        return "Customer (" + "id= " + id + ", email= " + email + ", age= " + age + ')';
    }
}
