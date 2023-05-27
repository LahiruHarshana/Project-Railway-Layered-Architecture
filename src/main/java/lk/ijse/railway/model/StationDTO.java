package lk.ijse.railway.model;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class StationDTO {

    private String id;
    private String name;

    private double distance;


    public StationDTO(double aDouble) {
        this.distance=aDouble;
    }
}
