package lk.ijse.railway.model;

import lombok.*;

import java.sql.Time;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class StationDetails {
    private String trainId;

    private String stationId;

    private Time time;

}
