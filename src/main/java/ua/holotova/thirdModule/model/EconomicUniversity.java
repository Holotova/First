package ua.holotova.thirdModule.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class EconomicUniversity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;

    @OneToMany(mappedBy = "university", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<StudyGroup> studyGroups;

    public EconomicUniversity(String name) {
        this.name = name;
    }
}
