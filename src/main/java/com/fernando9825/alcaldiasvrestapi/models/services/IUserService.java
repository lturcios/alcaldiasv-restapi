package com.fernando9825.alcaldiasvrestapi.models.services;

import com.fernando9825.alcaldiasvrestapi.models.entity.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    User findById(String username);

    User save(User user);

    void delete(String username);
}
