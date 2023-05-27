package lk.ijse.railway.model;

import lombok.*;

import java.sql.Date;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class BookingDTO {
    private String bId;
    private String cDate;
    private Date tDate;
    private String Tid;
    private String sName;
    private  String SeatId;
    private double price;

}
