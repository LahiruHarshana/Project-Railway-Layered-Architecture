package lk.ijse.railway.dto;

import lombok.*;

import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Train {
    private String id;
    private String name;
    private Time Time;

    private String endStation;

}
