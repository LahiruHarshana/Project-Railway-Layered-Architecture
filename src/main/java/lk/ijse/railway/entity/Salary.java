package lk.ijse.railway.entity;

import java.sql.Date;

import lombok.*;

@NoArgsConstructor
@Setter
@ToString
@Getter
@AllArgsConstructor

public class Salary {
    private String id;
    private String empId;
    private Date date;
    private Double amount;
}
