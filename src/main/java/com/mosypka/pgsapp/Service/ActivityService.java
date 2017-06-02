package com.mosypka.pgsapp.Service;

import com.mosypka.pgsapp.Model.Activity;
import com.mosypka.pgsapp.Model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by marcin on 22.04.2017.
 */
public interface ActivityService {

    List<Activity> getAllActivities();

    Activity getActivity(Long id);

    Activity updateActivity(Long id, String name, Date startDate);

    Activity addActivity(String name, Date startDate) throws Exception;

    Activity assignUserToActivity(Long activityId, User user);

    void deleteActivity(Long id);

    void addUser(Long activityId, User user);
}

