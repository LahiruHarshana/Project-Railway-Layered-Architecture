package lk.ijse.railway.model;

import lombok.*;
@ToString
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor

public class PaymentDTO {
    private String pId;
    private String tId;
    private String bId;
    private String date;
    private double price;

    public PaymentDTO(String pId, String tId, String date, double price) {
        this.pId = pId;
        this.tId = tId;
        this.date = date;
        this.price = price;
    }
}
