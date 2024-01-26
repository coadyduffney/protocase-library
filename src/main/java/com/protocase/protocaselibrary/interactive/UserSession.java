package com.protocase.protocaselibrary.interactive;

import com.protocase.protocaselibrary.fundamental.User;

/**
 * @author Coady Duffney
 */
public class UserSession {
    private User user;

    private static UserSession instance;

    private UserSession() {

    }

    public static UserSession getInstance() {
        if (null == instance) {
            instance = new UserSession();
        }

        return instance;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }


}
