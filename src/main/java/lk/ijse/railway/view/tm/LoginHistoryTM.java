package lk.ijse.railway.view.tm;

import java.sql.Date;
import java.sql.Time;


import lombok.*;
@ToString
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor

public class LoginHistoryTM {
    private int uId;
    private Date logInDate;
    private Time logInTime;
    private Date logOutDate;

    private Time logOutTime;

}
