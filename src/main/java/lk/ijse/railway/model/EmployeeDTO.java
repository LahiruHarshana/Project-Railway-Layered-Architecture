package lk.ijse.railway.model;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@Getter
@ToString
@Setter
@NoArgsConstructor

public class EmployeeDTO {

    private String id;
    private String name;
    private Date dob;
    private String contact;
    private String address;
}
