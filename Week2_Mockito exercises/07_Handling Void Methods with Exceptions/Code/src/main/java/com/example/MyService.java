package com.example;

public class MyService {
    private UserService userService;

    public MyService(UserService userService) {
        this.userService = userService;
    }

    public void removeUser(String id) {
        userService.deleteUser(id);
    }
}
