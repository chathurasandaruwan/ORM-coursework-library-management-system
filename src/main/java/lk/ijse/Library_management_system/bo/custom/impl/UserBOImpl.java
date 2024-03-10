package lk.ijse.Library_management_system.bo.custom.impl;

import lk.ijse.Library_management_system.bo.custom.UserBO;
import lk.ijse.Library_management_system.dao.custom.UserDAO;
import lk.ijse.Library_management_system.dao.custom.impl.UserDAOImpl;
import lk.ijse.Library_management_system.dto.UserDTO;
import lk.ijse.Library_management_system.entity.User;

public class UserBOImpl implements UserBO {
    UserDAO userDAO = new UserDAOImpl();
    @Override
    public void saveUser(UserDTO dto){
        userDAO.save(new User(dto.getName(), dto.getEmail(), dto.getPassword()));
    }
}
