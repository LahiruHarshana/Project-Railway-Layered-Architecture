package lk.ijse.railway.dto.tm;

import lombok.*;

@AllArgsConstructor
@Getter
@ToString
@Setter
@NoArgsConstructor

public class StationTM {
    private String id;
    private String name;
    private double distance;
}
