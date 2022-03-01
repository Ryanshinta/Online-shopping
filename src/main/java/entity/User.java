package entity;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private String username;
    private String password;
    private ArrayList<item> WishList;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, ArrayList wishList) {
        this.username = username;
        this.password = password;
        WishList = wishList;
    }

    public ArrayList getWishList() {
        return WishList;
    }

    public void setWishList(ArrayList wishList) {
        WishList = wishList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "username : " + username + ", password : " + password;
    }

}
