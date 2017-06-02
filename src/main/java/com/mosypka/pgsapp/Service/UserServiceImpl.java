package com.mosypka.pgsapp.Service;

import com.mosypka.pgsapp.Model.Activity;
import com.mosypka.pgsapp.Model.User;
import com.mosypka.pgsapp.Repository.ActivityRepository;
import com.mosypka.pgsapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by marcin on 05.04.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> getUsers() {

        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }
    @Override
    public void deleteUser(User u) {
        userRepository.delete(u.getId());
    }

    @Override
    public User updateUser(Long id,User user) {
        User u = userRepository.findOne(id);
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setEmail(user.getEmail());
        u = userRepository.save(u);
        return u;
    }

    @Override
    public User createUser(User user) {
        return  userRepository.save(user);
    }
}
