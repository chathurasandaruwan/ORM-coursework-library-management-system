package lk.ijse.Library_management_system.dto;

import lk.ijse.Library_management_system.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {
    private long id;
    private String name;
    private String email;
    private String password;


    public UserDTO( String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public User toEntity(){
        User user= new User(id,name,email,password);
        return user;
    }
}
