package ua.holotova.hw24.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString(exclude = "factory")
@NoArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private String model;
    private Integer price;
    private LocalDate date;
    private String description;
    private Boolean availability;
    @ManyToOne
    @JoinColumn(name = "factory_id")
    private Factory factory;

    public Device(String type, String model, Integer price, LocalDate date, String description, Boolean availability, Factory factory) {
        this.type = type;
        this.model = model;
        this.price = price;
        this.date = date;
        this.description = description;
        this.availability = availability;
        this.factory = factory;
    }
}

