package lk.ijse.railway.model;

import lombok.*;

import java.sql.Date;
import java.sql.Time;
@ToString
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor

public class LoginHistoryDTO {
    private int uId;
    private Date logInDate;
    private Time logInTime;
    private Date logOutDate;

    private Time logOutTime;

    public LoginHistoryDTO(int uId, Date logInDate, Time logInTime) {
        this.uId = uId;
        this.logInDate = logInDate;
        this.logInTime = logInTime;
    }

    public LoginHistoryDTO(int uId) {
        this.uId=uId;
    }
}
