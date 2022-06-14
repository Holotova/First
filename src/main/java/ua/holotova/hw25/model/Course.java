package ua.holotova.hw25.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "studentSet")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;
    private Integer difficulty;

    @ManyToMany(mappedBy = "courseSet")
    private Set<Student> studentSet;

    public Course(String name, Integer difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }
}
