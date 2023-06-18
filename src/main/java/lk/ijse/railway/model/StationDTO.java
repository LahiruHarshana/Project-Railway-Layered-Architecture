package lk.ijse.railway.model;
import lk.ijse.railway.entity.Station;
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

    public StationDTO(Station search) {
        this.distance=search.getDistance();
        this.id=search.getId();
        this.name=search.getName();
    }

}
