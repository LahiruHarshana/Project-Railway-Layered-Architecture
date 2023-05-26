package lk.ijse.railway.dto;

import javafx.scene.layout.Pane;

import java.sql.Date;
import java.sql.Time;

import lombok.*;
@ToString
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor

public class LoginHistory {
    private int uId;
    private Date logInDate;
    private Time logInTime;
    private Date logOutDate;

    private Time logOutTime;

    public LoginHistory(int uId, Date logInDate, Time logInTime) {
        this.uId = uId;
        this.logInDate = logInDate;
        this.logInTime = logInTime;
    }
}
