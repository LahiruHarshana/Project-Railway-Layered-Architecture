package lk.ijse.railway.entity;

import lombok.*;
@ToString
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor

public class Payment {
    private String pId;
    private String tId;
    private String bId;
    private String date;
    private double price;

    public Payment(String pId, String tId, String date, double price) {
        this.pId = pId;
        this.tId = tId;
        this.date = date;
        this.price = price;
    }
}
