package com.mosypka.pgsapp.Controller;

import com.mosypka.pgsapp.Model.Activity;
import com.mosypka.pgsapp.Model.User;
import com.mosypka.pgsapp.Service.ActivityService;
import com.mosypka.pgsapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by marcin on 01.04.2017.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ActivityService activityService;


    @GetMapping("/")
    public List get() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") long id){
        User user = userService.getUser(id);
        if(user == null) {
            return new ResponseEntity("No user found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(user,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") long id) {
        User u = userService.getUser(id);
        if(u == null) {
            return new ResponseEntity("User not found.", HttpStatus.NOT_FOUND);
        }
        userService.deleteUser(u);
        return new ResponseEntity(u, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") long id, @RequestBody User user) {
        User u = userService.getUser(id);
        if(u == null) {
            return new ResponseEntity("No user found for ID " + id, HttpStatus.NOT_FOUND);
        }
        User updatedUser = userService.updateUser(id,user);
        return new ResponseEntity(updatedUser, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity post(@RequestBody User user) {
        User u = userService.createUser(user);
        return new ResponseEntity(u,HttpStatus.OK);
    }

    @PostMapping("{id}/activities")
    public ResponseEntity addActivities(@PathVariable("id") Long id, @RequestBody Activity activity) {
        User u = userService.getUser(id);
        Activity a = activityService.getActivity(activity.getId());
        if(u == null || a == null) {
            return ResponseEntity.notFound().build();
        }
        activityService.addUser(a.getId(),u);
        return ResponseEntity.ok().build();
    }

    }
