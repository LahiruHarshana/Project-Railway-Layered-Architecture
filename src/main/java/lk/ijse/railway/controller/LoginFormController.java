package lk.ijse.railway.controller;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.railway.Notification.Notification;
import lk.ijse.railway.dto.User;
import lk.ijse.railway.dao.UserModel;
import lk.ijse.railway.dao.loginHistoryModel;
import lk.ijse.railway.util.AlertTypes;
import lk.ijse.railway.util.TimeChecker;
import lombok.SneakyThrows;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class LoginFormController implements Initializable {

    private Pane registerPane;

    @FXML
    private Button btnSignUp;

    String password;
    @FXML
    private Button loginButton;

    int uid;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUser;


    @FXML
    private Label wrongPassword;

    @FXML
    private Label wrongUser;

    Stage stage;

    int eka;

    @FXML
    void loginButtonOnAction(ActionEvent event) throws IOException {
        wrongUser.setVisible(false);
        wrongPassword.setVisible(false);
        String user = txtUser.getText();

        try {
            User user1 = UserModel.search1(txtUser.getText());
            if (user1 != null) {
                password=user1.getPswd();
                System.out.println(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Notification.notification(AlertTypes.ERROR,"ERROR !","something happened!");
        }

        if(txtUser.getText().equals(user) && txtPassword.getText().equals(password)) {

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/menu_form.fxml"));
                registerPane = fxmlLoader.load();
                anchorPane.getChildren().clear();
                anchorPane.getChildren().setAll(registerPane);
                System.gc();
                eka = 1;
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                User user1 = UserModel.search1(txtUser.getText());
                if (user1 != null) {
                    uid = user1.getUId();


                }
            } catch (SQLException e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "something happened!").show();
            }

            try {
                LocalDate currentDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String formattedDate = currentDate.format(formatter);
                Date date = Date.valueOf(formattedDate);

                LocalTime time = LocalTime.now();
                Time time1 = Time.valueOf(time);

                boolean isSaved = loginHistoryModel.save(uid,date,time1);
                if (isSaved) {
                    Notification.notification(AlertTypes.CONFORMATION,"CONFIRMATION ","Saved Log History");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                Notification.notification(AlertTypes.ERROR,"ERROR !","Something Happened");
            }

        }else if(txtUser.getText().equals(user)){
            wrongPassword.setVisible(true);

            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(50), wrongPassword);
            translateTransition.setFromX(0);
            translateTransition.setToX(10);
            translateTransition.setCycleCount(10);
            translateTransition.setAutoReverse(true);
            translateTransition.play();

            try {
                File audioFile = new File("src/main/resources/Sounds/ttsMP3.com_VoiceText_2023-4-30_1_39_54.mp3");
                FileInputStream audioStream = new FileInputStream(audioFile);
                Player player = new Player(audioStream);
                player.play();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }else if(txtPassword.getText().equals(password)){

            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(50), wrongUser);
            translateTransition.setFromX(0);
            translateTransition.setToX(10);
            translateTransition.setCycleCount(10);
            translateTransition.setAutoReverse(true);

            translateTransition.play();
            wrongUser.setVisible(true);
        }else{
            Notification.notification(AlertTypes.ERROR,"ERROR!","Log in Failed.Try Again.");
        }
    }
    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TimeChecker.tread();

    }
    @FXML
    void btnSignUpOnAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/signUp_form.fxml"));
            registerPane = fxmlLoader.load();
            anchorPane.getChildren().clear();
            anchorPane.getChildren().setAll(registerPane);
            System.gc();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void vibrete() {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(50), wrongUser);
        translateTransition.setFromX(0);
        translateTransition.setToX(10);
        translateTransition.setCycleCount(10);
        translateTransition.setAutoReverse(true);

    }


}
