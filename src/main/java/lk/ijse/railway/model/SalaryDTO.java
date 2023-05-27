package lk.ijse.railway.model;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@Setter
@ToString
@Getter
@AllArgsConstructor

public class SalaryDTO {
    private String id;
    private String empId;
    private Date date;
    private Double amount;
}
