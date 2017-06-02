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
 * Created by marcin on 28.04.2017.
 */
@RestController
@RequestMapping("/activities")

public class ActivityController {

    @Autowired
    private ActivityService activityService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<Activity>> getActivities() {
       List<Activity> activities =  activityService.getAllActivities();
       return new ResponseEntity<>(activities,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Activity> getActivity(@PathVariable("id") Long id) {
        Activity activity = activityService.getActivity(id);
        return new ResponseEntity<Activity>(HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) throws Exception{
        Activity a = activityService.addActivity(activity.getName(),activity.getStartDate());
        return new ResponseEntity<Activity>(a,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable("id") Long id,@RequestBody Activity activity){
        activityService.updateActivity(id,activity.getName(),activity.getStartDate());
        return new ResponseEntity<Activity>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable("id") Long id) {
        activityService.deleteActivity(id);
    }

    @GetMapping("{id}/users")
    public ResponseEntity<List<User>> getUsers(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(activityService.getActivity(id).getUsers());
    }
}
