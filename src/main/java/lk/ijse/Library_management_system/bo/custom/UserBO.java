package lk.ijse.Library_management_system.bo.custom;

import lk.ijse.Library_management_system.dto.UserDTO;

import java.util.List;

public interface UserBO {
    boolean saveUser(UserDTO dto);

    List<UserDTO> getAllUser();

    boolean updateUser(UserDTO dto);


    boolean deleteUser(long id);
}
