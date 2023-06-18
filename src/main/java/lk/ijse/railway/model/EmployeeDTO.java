package lk.ijse.railway.model;

import lk.ijse.railway.entity.Employee;
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

    public EmployeeDTO(Employee search) {
        id=search.getId();
        name=search.getName();
        dob=search.getDob();
        contact=search.getContact();
        address=search.getAddress();
    }
}
