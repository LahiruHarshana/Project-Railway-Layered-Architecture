package lk.ijse.railway.model;

import lombok.*;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
@ToString

public class UserDTO {
    private int uId;

    private String name;

    private String pswd;

    private String num;

    private String address;

    private String email;

    public UserDTO(int uId, String name, String num, String address, String email) {
        this.uId=uId;
        this.name=name;
        this.num=num;
        this.address=address;
        this.email=email;
    }

    public UserDTO(int uId, String currentPswd) {
        this.uId=uId;
        this.pswd=currentPswd;
    }
}
