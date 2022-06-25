package ua.holotova.thirdModule.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StudyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private EconomicUniversity university;

    @OneToMany(mappedBy = "studyGroup", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Learner> learners;

    public StudyGroup(String name, EconomicUniversity university) {
        this.name = name;
        this.university = university;
    }

    @Override
    public String toString() {
        return String.format("Group %s", name);
    }
}
