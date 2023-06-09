package lk.ijse.railway.model;

import lombok.*;

@AllArgsConstructor
@Getter
@ToString
@Setter
@NoArgsConstructor

public class PassengerDTO {
    private String id;
    private String name;
    private String bookinId;
    private String contact;
    private String email;
    private String address;
    private String nic;

    public PassengerDTO(String id) {
        this.id= id;
    }
}
