package lk.ijse.Library_management_system.bo.custom.impl;

import lk.ijse.Library_management_system.bo.custom.UserBO;
import lk.ijse.Library_management_system.dao.custom.UserDAO;
import lk.ijse.Library_management_system.dao.custom.impl.UserDAOImpl;
import lk.ijse.Library_management_system.dto.UserDTO;
import lk.ijse.Library_management_system.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {
    UserDAO userDAO = new UserDAOImpl();
    @Override
    public boolean saveUser(UserDTO dto){
        return userDAO.save(new User(dto.getName(), dto.getEmail(), dto.getPassword()));
    }
    @Override
    public List<UserDTO> getAllUser(){
        List<UserDTO>userDTOS =new ArrayList<>();
        List<User> users = userDAO.getAll();
        for (User user : users) {
            userDTOS.add(new UserDTO(user.getId(),user.getName(),user.getEmail(),user.getPassword()));
        }
        return userDTOS;
    }
    @Override
    public boolean updateUser(UserDTO dto){
        return userDAO.update(new User(dto.getId(),dto.getName(), dto.getEmail(), dto.getPassword()));
    }
}
