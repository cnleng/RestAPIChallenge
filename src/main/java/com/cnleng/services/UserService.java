package com.cnleng.services;

import com.cnleng.api.request.UserRequest;
import com.cnleng.dao.IUserDAO;
import com.cnleng.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserService")
public class UserService implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public Long createUser(UserRequest userRequest) {
        User u = new User(userRequest.getName(), userRequest.getEmail());
        User newUser = userDAO.save(u);
        return newUser.getId();
    }

    @Override
    @Transactional
    public void deleteUser(Long userId) {
        userDAO.deleteById(userId);
    }

}
