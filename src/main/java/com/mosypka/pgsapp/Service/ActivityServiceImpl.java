package com.mosypka.pgsapp.Service;

import com.mosypka.pgsapp.Model.Activity;
import com.mosypka.pgsapp.Model.User;
import com.mosypka.pgsapp.Repository.ActivityRepository;
import com.mosypka.pgsapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by marcin on 22.04.2017.
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    private static final int MAX_ACTIVITIES = 8;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    @Override
    public Activity getActivity(Long id) {
        return activityRepository.findOne(id);
    }

    @Override
    public Activity updateActivity(Long id,String name,Date startDate) {
        Activity a = activityRepository.findOne(id);
        a.setName(name);
        a.setStartDate(startDate);
        return activityRepository.save(a);
    }

    @Override
    public Activity addActivity(String name, Date startDate)  throws Exception{
        if(activityRepository.count() >= 8) {
           throw new Exception("Max activities count reached");
        }
        Activity activity = new Activity();
        activity.setName(name);
        activity.setStartDate(new Date(startDate.getTime()));
        return activityRepository.save(activity);
    }

    @Override
    public void deleteActivity(Long id) {
        activityRepository.delete(id);
    }

    @Override
    public Activity assignUserToActivity(Long id, User user) {
        Activity a = activityRepository.findOne(id);
        a.addUser(user);
        return activityRepository.save(a);
    }

    @Override
    public void addUser(Long activityId, User user) {
        Activity a = activityRepository.findOne(activityId);
        Collection<User> users = a.getUsers();
        if(!users.contains(user)) {
           users.add(user);
        }
        activityRepository.save(a);
    }
}
