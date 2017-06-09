package com.mosypka.pgsapp.Controller;

import com.mosypka.pgsapp.DTO.ActivityDTO;
import com.mosypka.pgsapp.DTO.UserDTO;
import com.mosypka.pgsapp.Model.Activity;
import com.mosypka.pgsapp.Model.User;
import com.mosypka.pgsapp.Service.ActivityService;
import com.mosypka.pgsapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import static com.mosypka.pgsapp.Converter.Converter.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<List<ActivityDTO>> getActivities() {
       List<Activity> activities =  activityService.getAllActivities();
       return new ResponseEntity<>(activities.stream().map(activity -> toActivityDTO(activity)).collect(Collectors.toList()),HttpStatus.OK);
    }
    @GetMapping("/{id}/")
    public ResponseEntity<ActivityDTO> getActivity(@PathVariable("id") Long id) {
        Activity activity = activityService.getActivity(id);
        if(activity == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(toActivityDTO(activity),HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<ActivityDTO> createActivity(@Validated @RequestBody ActivityDTO activityDTO) throws Exception{
        Activity a = activityService.addActivity(activityDTO.getName(),activityDTO.getStartDate());
        return new ResponseEntity<>(toActivityDTO(a),HttpStatus.OK);
    }
    @PutMapping("/{id}/")
    public ResponseEntity<ActivityDTO> updateActivity(@PathVariable("id") Long id,@Validated @RequestBody ActivityDTO activityDTO){
        if(activityService.getActivity(id) != null) {
            activityService.updateActivity(id,activityDTO.getName(),activityDTO.getStartDate());
            return new ResponseEntity<>(HttpStatus.OK);
        }
            return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}/")
    public ResponseEntity deleteActivity(@PathVariable("id") Long id) {
        if(activityService.getActivity(id) != null){
            activityService.deleteActivity(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("{id}/users/")
    public ResponseEntity<List<UserDTO>> getUsers(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(activityService.getActivity(id).getUsers().stream().map(user -> toUserDTO(user)).collect(Collectors.toList()));
    }
}
