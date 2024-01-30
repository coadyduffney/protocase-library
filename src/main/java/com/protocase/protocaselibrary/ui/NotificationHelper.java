package com.protocase.protocaselibrary.ui;

import com.protocase.protocaselibrary.App;
import com.protocase.protocaselibrary.fundamental.User;
import com.protocase.protocaselibrary.interactive.UserSession;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * @author Coady Duffney
 */
public class NotificationHelper {

    public static void showLogOutNotification() {
        showNotification("Goodbye");
    }

    public static void showLogInNotification() {
        showNotification("Welcome");
    }

    private static void showNotification(String text) {
        User user = UserSession.getInstance().getUser();

        Platform.runLater(() -> {
            Notifications
                    .create()
                    .text(text + ", " + user.getFirstName() + " " + user.getLastName())
                    .graphic(new ImageView(new Image(NotificationHelper.class.getResourceAsStream("/images/favicon-32x32.png"))))
                    .position(Pos.BOTTOM_RIGHT)
                    .owner(App.WINDOW)
                    .hideAfter(Duration.seconds(1))
                    .show();
        });
    }
}
