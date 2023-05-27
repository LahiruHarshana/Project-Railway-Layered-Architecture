package lk.ijse.railway.dto;

import java.sql.Date;

import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Booking {
    private String bId;
    private String cDate;
    private Date tDate;
    private String Tid;
    private String sName;
    private  String SeatId;
    private double price;

}
