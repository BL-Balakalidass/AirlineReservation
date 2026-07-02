package service;

import model.User;
import util.PasswordUtil;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> users = new ArrayList<>();

    public void register(User user) {

        user.setPassword(
                PasswordUtil.encryptPassword(user.getPassword()));

        users.add(user);

        System.out.println("Registration Successful.");
    }

    public void updateProfile(User user) {
        System.out.println("Profile Updated.");
    }

    public void deactivateUser(User user) {

        users.remove(user);

        System.out.println("Account Deleted.");
    }

    public void displayAllUsers() {

        for (User user : users) {
            System.out.println(user);
            System.out.println("----------------");
        }
    }

    public List<User> getUsers() {
        return users;
    }
}