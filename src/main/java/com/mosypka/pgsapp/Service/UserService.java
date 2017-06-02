package com.mosypka.pgsapp.Service;

import com.mosypka.pgsapp.Model.Activity;
import com.mosypka.pgsapp.Model.User;

import java.util.List;



public interface UserService {
    User getUser(Long id);
    List<User> getUsers();
    void deleteUser(Long id);
    void deleteUser(User u);
    User updateUser(Long id,User user);
    User createUser(User user);
}
