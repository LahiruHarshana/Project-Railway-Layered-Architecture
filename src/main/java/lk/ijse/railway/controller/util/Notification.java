package lk.ijse.railway.controller.util;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class Notification {
    public static void notification(AlertTypes alert,String title,String text){
        Image image;
        switch (alert){
            case ERROR -> image = new Image("/img/cancel.png");
            case WARNING -> image = new Image("/img/warning 14.59.38.png");
            case INFORMATION -> image = new Image("/img/information.png");
            case CONFORMATION -> image = new Image("/img/verified (1).png");
            default -> throw new IllegalStateException("Unexpected value : " + alert);
        }
        Notifications notificationBuilder = Notifications.create()
                .title(title)
                .text(text)
                .graphic(new ImageView(image))
                .hideAfter(Duration.seconds(4))
                .position(Pos.CENTER_RIGHT)
                .onAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {

                    }
                });
        notificationBuilder.darkStyle();
        notificationBuilder.show();

    }
}
