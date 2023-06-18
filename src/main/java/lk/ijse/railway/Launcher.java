package lk.ijse.railway;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Image image=new Image("/img/train.png");
        Parent parent =  FXMLLoader.load(getClass().getResource("/view/loginPage_form.fxml"));
        stage.getIcons().add(image);
        stage.setScene(new Scene(parent));
        stage.setTitle("Railway Station");
        stage.centerOnScreen();
        stage.setResizable(false);

        stage.show();

    }

}
