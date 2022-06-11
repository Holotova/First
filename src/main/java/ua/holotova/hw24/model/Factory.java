package ua.holotova.hw24.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString(exclude = "devices")
@NoArgsConstructor
public class Factory {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;

    private String country;

    @OneToMany(mappedBy = "factory", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Device> devices;

    public Factory(String name, String country) {
        this.name = name;
        this.country = country;
    }
}
