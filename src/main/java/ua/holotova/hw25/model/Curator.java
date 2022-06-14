package ua.holotova.hw25.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "universityGroup")
public class Curator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;
    private LocalDate birthDate;
    private Integer workExperience;

    @OneToOne
    private UniversityGroup universityGroup;

    public Curator(String name, LocalDate birthDate, Integer workExperience) {
        this.name = name;
        this.birthDate = birthDate;
        this.workExperience = workExperience;
    }
}
