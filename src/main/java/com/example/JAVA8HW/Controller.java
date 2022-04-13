package com.example.JAVA8HW;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final Service service;

    @PostMapping("/users")
    public List<User> createUsers(){
        return service.createUsers();
    }

    @PostMapping("/usersUnder18")
    public List<User> filterUsersUnder18(){
        return service.filterUsersByAgeLessThan18(service.createUsers());
    }

    @PostMapping("/doubleAge")
    public List<User> doubleUserAge(){
        return service.doubleUsersAge(service.createUsers());
    }

    @PostMapping("/lastUser")
    public User lastUser(){
        return service.getLastUser(service.createUsers());
    }

    @PostMapping("/youngestUser")
    public List<Integer> getYoungestUser(){
        return service.getYoungestUser(service.createUsers());
    }

    @PostMapping("/oldestUser")
    public List<Integer> getOldestUser(){
        return service.getOldestUser(service.createUsers());
    }

    @PostMapping("/removeDuplicates")
    public List<User> removeDuplicates(){
        return service.removeDuplicates(service.createUsers());
    }

    @PostMapping("/filterUsers")
    public List<User> filterUsers(){
        return service.filterUsers(service.createUsers());
    }

}




