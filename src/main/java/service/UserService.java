/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entity.User;
import dao.userMapper;
import java.util.ArrayList;

/**
 *
 * @author YoonEn
 */
public class UserService implements userMapper {
    private static ArrayList<User> UserArray = new ArrayList<User>();

    @Override
    public boolean newUser(User u) {
        if(UserArray.add(u)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(User u) {
        if(UserArray.remove(u)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User old, User newUser) {
        int i = UserArray.indexOf(old);
        UserArray.add(i, newUser);
        return true;
    }

    @Override
    public User searchByUsername(String username) {
        for(User user:UserArray) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean searchByUsernameBoolean(String username) {
        for(User user:UserArray) {
            if(user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean containUser(User u) {
        for(User user:UserArray) {
            if(user.equals(u)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String displayAllUser() {
        String str = "";
        if(UserArray.isEmpty()) {
            return null;
        }
        for(int i = 0; i < UserArray.size(); i++) {
            str += String.format("%02d. %-20s %-20s\n", i + 1, UserArray.get(i).getUsername(), UserArray.get(i).getPassword());
        }
        return str;
    }

    @Override
    public boolean resetPassword(String username, String newPassword) {
        for(User user:UserArray) {
            if(user.getUsername().equals(username)) {
                user.setPassword(newPassword);
                return true;
            }
        }
        return false;
    }
}
