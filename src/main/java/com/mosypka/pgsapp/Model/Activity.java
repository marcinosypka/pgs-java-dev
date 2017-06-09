package com.mosypka.pgsapp.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Created by marcin on 06.04.2017.
 */
@Entity
@Table(name="activity")
public class Activity implements Comparable<Activity> {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private Date startDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="attendance",
            joinColumns = @JoinColumn(name="activity_id"),
            inverseJoinColumns = @JoinColumn(name ="user_id")
    )
    private List<User> users;

    public Activity() {
    }

    public Activity(String name, Date startDate, List<User> users) {
        this.name = name;
        this.startDate = startDate;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users.addAll(users);
    }

    public void addUser(User user){
        users.add(user);
    }

    @Override
    public int compareTo(Activity a) {
        return startDate.toString().compareTo(a.getStartDate().toString());
    }
}
