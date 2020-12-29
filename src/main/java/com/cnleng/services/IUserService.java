package com.cnleng.services;

import com.cnleng.api.request.UserRequest;

public interface IUserService {

    Long createUser(UserRequest userRequest);

    void deleteUser(Long userId);

}
