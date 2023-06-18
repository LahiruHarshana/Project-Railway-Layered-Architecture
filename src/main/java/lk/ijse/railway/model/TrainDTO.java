package lk.ijse.railway.model;

import lk.ijse.railway.entity.Train;
import lombok.*;

import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class TrainDTO {
    private String id;
    private String name;
    private Time Time;

    private String endStation;

    public TrainDTO(Train search) {
        this.endStation=search.getEndStation();
        this.id=search.getId();
        this.name=search.getName();
        this.Time=search.getTime();
    }
}
