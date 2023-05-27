package lk.ijse.railway.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Station {

    private String id;
    private String name;

    private double distance;


    public Station(double aDouble) {
        this.distance=aDouble;
    }
}
