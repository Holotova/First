package fourthModule.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    private Long timeForDetail;
    private Integer fuel;
    private Integer brokenSchema;

    public Detail(LocalDate date, Long timeForDetail, Integer fuel, Integer brokenSchema) {
        this.date = date;
        this.timeForDetail = timeForDetail;
        this.fuel = fuel;
        this.brokenSchema = brokenSchema;
    }

    @Override
    public String toString() {
        return "Production date - " + date +
                ", time for one detail - " + timeForDetail +
                ", produced fuel - " + fuel +
                ", broken chips - " + brokenSchema +
                '.';
    }
}
