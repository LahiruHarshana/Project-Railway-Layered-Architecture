package lk.ijse.railway.dto;

import lombok.*;

import java.sql.Time;
import java.util.zip.ZipEntry;

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
