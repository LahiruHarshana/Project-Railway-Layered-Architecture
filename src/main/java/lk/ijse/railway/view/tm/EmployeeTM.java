package lk.ijse.railway.view.tm;

import java.sql.Date;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class EmployeeTM {
    private String id;
    private String name;
    private Date dob;
    private String contact;

    private String address;
}
