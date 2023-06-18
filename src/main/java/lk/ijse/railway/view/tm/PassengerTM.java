package lk.ijse.railway.view.tm;


import lombok.*;

@AllArgsConstructor
@Getter
@ToString
@Setter
@NoArgsConstructor

public class PassengerTM {

    private String id;
    private String name;
    private String bookinId;
    private String contact;
    private String email;
    private String address;
    private String nic;
}
