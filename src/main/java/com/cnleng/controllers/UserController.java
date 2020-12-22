package com.cnleng.controllers;

import com.cnleng.services.IUserService;
import com.cnleng.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Constants.URL_USER)
public class UserController {

    @Autowired
    @Qualifier("UserService")
    private IUserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public void createUser() {

    }

    @RequestMapping(method = RequestMethod.GET)
    public void getUser() {

    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateUser() {

    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteUser() {

    }

}
