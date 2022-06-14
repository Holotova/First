package ua.holotova.hw26.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String status;
    private List<String> orders;

    public Customer(String firstName, String lastName, Integer age, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.status = status;
        this.id = UUID.randomUUID().toString();
    }
}
