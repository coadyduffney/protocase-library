package com.protocase.protocaselibrary.interactive;

import com.protocase.protocaselibrary.fundamental.User;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 * @author Coady Duffney
 */
public class UserSession {
    private final BooleanProperty userLoggedInProperty;
    private User user;

    private static UserSession instance;

    private UserSession() {
        userLoggedInProperty = new SimpleBooleanProperty(false);
    }

    public static UserSession getInstance() {
        if (null == instance) {
            instance = new UserSession();
        }

        return instance;
    }

    public BooleanProperty getUserLoggedInProperty() {
        return userLoggedInProperty;
    }

    public void setUser(User user) {
        this.user = user;
        userLoggedInProperty.set(null != user);
    }

    public User getUser() {
        return user;
    }


}
