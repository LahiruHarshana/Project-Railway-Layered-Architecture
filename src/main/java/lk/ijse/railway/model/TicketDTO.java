package lk.ijse.railway.model;

import lombok.*;

@NoArgsConstructor
@Setter
@ToString
@Getter
@AllArgsConstructor

public class TicketDTO {
    private String tId;
    private String trainId;
    private String sName;
    private String cType;
    private int HowMany;
    private double price;


}
