package lk.ijse.railway.dto;

import lombok.*;

@NoArgsConstructor
@Setter
@ToString
@Getter
@AllArgsConstructor

public class Ticket {
    private String tId;
    private String trainId;
    private String sName;
    private String cType;
    private int HowMany;
    private double price;


}
