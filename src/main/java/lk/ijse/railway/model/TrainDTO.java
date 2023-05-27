package lk.ijse.railway.model;

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

}
