package lk.ijse.railway.model;

import lk.ijse.railway.entity.User;
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

    public UserDTO(String pswd) {
        this.pswd = pswd;
    }

    public UserDTO(User search) {
        this.pswd=search.getPswd();
    }

    public UserDTO(User search,String s) {
        this.pswd=search.getPswd();
        this.uId=search.getUId();
        this.num=search.getNum();
        this.name=search.getName();
        this.address=search.getAddress();
        this.email=search.getEmail();
    }

    public UserDTO(int uId, String s, String t) {
        this.uId=uId;
    }
}
