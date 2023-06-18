package lk.ijse.railway.view.tm;

import lombok.*;

import java.sql.Time;

@NoArgsConstructor
@Setter
@ToString
@Getter
@AllArgsConstructor


public class TrainTM {
    private String id;
    private String name;

    private Time time;

    private String endStation;

}
