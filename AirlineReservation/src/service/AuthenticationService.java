package service;

import model.User;
import util.PasswordUtil;

public class AuthenticationService {

    public boolean login(User user,
                         String username,
                         String password) {

        String encrypted =
                PasswordUtil.encryptPassword(password);

        return user.getUsername().equals(username)
                &&
                user.getPassword().equals(encrypted);
    }

    public void forgotPassword(User user,
                               String newPassword) {

        user.setPassword(
                PasswordUtil.encryptPassword(newPassword));

        System.out.println("Password Updated.");
    }

}