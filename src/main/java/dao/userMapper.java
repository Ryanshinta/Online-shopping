/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import entity.User;
import entity.item;

/**
 *
 * @author YoonEn
 */
public interface userMapper {

    boolean newUser(User u);

    boolean deleteUser(User u);

    boolean updateUser(User o, User n);
    
    boolean resetPassword(String username, String newPassword);

    User searchByUsername(String username);
    
    boolean searchByUsernameBoolean(String username);
    
    boolean containUser(User u);

    String displayAllUser();


}
