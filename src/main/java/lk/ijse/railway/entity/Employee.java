package lk.ijse.railway.entity;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@Getter
@ToString
@Setter
@NoArgsConstructor

public class Employee {

    private String id;
    private String name;
    private Date dob;
    private String contact;
    private String address;
}
