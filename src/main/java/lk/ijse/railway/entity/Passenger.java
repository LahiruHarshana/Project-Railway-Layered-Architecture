package lk.ijse.railway.entity;

import lombok.*;

@AllArgsConstructor
@Getter
@ToString
@Setter
@NoArgsConstructor

public class Passenger {
    private String id;
    private String name;
    private String bookinId;
    private String contact;
    private String email;
    private String address;
    private String nic;
}
