package com.mosypka.pgsapp.Converter;

import com.mosypka.pgsapp.DTO.ActivityDTO;
import com.mosypka.pgsapp.DTO.UserDTO;
import com.mosypka.pgsapp.Model.Activity;
import com.mosypka.pgsapp.Model.User;

/**
 * Created by marcin on 09.06.2017.
 */
public class Converter {
    public static UserDTO toUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmailAddress(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        return userDTO;
    }
    public static User fromUserDTO(UserDTO userDTO){
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmailAddress());
        user.setPassword(userDTO.getPassword());
        user.setRole(User.Role.STUDENT);
        return user;
    }
    public static Activity fromActivityDTO(ActivityDTO activityDTO) {
        Activity activity = new Activity();
        activity.setName(activityDTO.getName());
        activity.setStartDate(activityDTO.getStartDate());

        return activity;
    }
    public static ActivityDTO toActivityDTO(Activity activity) {
        ActivityDTO activityDTO = new ActivityDTO();
        activityDTO.setId(activity.getId());
        activityDTO.setName(activity.getName());
        activityDTO.setStartDate(activity.getStartDate());
        return activityDTO;
    }
}
