package com.cnleng.dao;

import com.cnleng.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDAO  extends CrudRepository<User, Long> {
}
