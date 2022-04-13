package com.example.JAVA8HW;

import java.util.*;


public class Service {
    private int randomAge() {
        return (int) (Math.random() * 100);
    }

    public static String randomName(){
        Name[] values = Name.values();
        int length = values.length;
        int randomIndex = (int) (Math.random() * length);
        return values[randomIndex].name();
    }

    public List<User> createUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1,randomName(), randomAge()));
        users.add(new User(2,randomName(), randomAge()));
        users.add(new User(3,randomName(), randomAge()));
        return users;
    }

    public List<User> filterUsersByAgeLessThan18(List<User> users){
        return users.stream().filter(user -> user.getAge() < 18)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public List<User> doubleUsersAge(List<User>users){
        return users.stream().map(user -> new User(user.getId(), user.getName(), user.getAge() * 2))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public User getLastUser(List<User> users){
        return users.stream().reduce((u1, u2) -> u2).get();
    }

    public List<Integer> getYoungestUser(List<User> users){
        return Collections.singletonList(users.stream().map(user -> user.getAge())
                .reduce(Integer::max).get());
    }

    public List<Integer> getOldestUser(List<User> users){
        return Collections.singletonList(users.stream().map(user -> user.getAge())
                .reduce(Integer::min).get());
    }

    public List<User> removeDuplicates(List<User> users){
        return users.stream().distinct().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public List<User> filterUsers(List<User> users){
        return users.stream().filter(user -> user.getAge() > 30).map(user -> new User(user.getId(), user
                .getName().toUpperCase(), user.getAge())).sorted((u1, u2) -> u2.getAge() - u1.getAge())
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

}
