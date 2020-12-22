package com.cnleng.services;

import com.cnleng.dao.IBookingDAO;
import com.cnleng.dao.IUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Autowired
    private IBookingDAO bookingDAO;


}
