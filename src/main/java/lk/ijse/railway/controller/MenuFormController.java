package lk.ijse.railway.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import lk.ijse.railway.dao.custom.impl.LoginHistoryDAOImpl;

import java.io.IOException;

public class MenuFormController {

    @FXML
    private AnchorPane changePane;

    @FXML
    private JFXButton btnSetting;

    @FXML
    private ImageView empImg;

    @FXML
    private JFXButton employeeButton;

    @FXML
    private JFXButton homeButton;

    @FXML
    private JFXButton passengerButton;

    @FXML
    private  ImageView imgSetting;

    @FXML
    private JFXButton salaryButton;

    @FXML
    private JFXButton scheduleButton;

    @FXML
    private ImageView imgHome;


    @FXML
    private ImageView imgPassenger;

    @FXML
    private ImageView imgSalary;

    @FXML
    private ImageView imgSchedule;

    @FXML
    private ImageView imgTicket;

    @FXML
    private ImageView imgTrain;

    @FXML
    private JFXButton ticketButton;

    @FXML
    private JFXButton trainButton;

    @FXML
    void btnSettingOnAction(ActionEvent event) throws IOException {
        setUI("setting_form.fxml");

    }

    @FXML
    void employeeButtonOnAction(ActionEvent event) throws IOException {
        transition(employeeButton, empImg);
        setUI("employee_form.fxml");

    }

    void transition(JFXButton button, ImageView img) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(500), button);
        transition.setByX(50);
        transition.setCycleCount(2);
        transition.setAutoReverse(true);
        transition.play();

        TranslateTransition transition1 = new TranslateTransition(Duration.millis(500), img);
        transition1.setByX(50);
        transition1.setCycleCount(2);
        transition1.setAutoReverse(true);
        transition1.play();

    }

    @FXML
    void homeButtonOnAction(ActionEvent event) throws IOException {
        transition(homeButton, imgHome);


        setUI("home_form.fxml");


    }



    @FXML
    void passengerButtonOnAction(ActionEvent event) throws IOException {
        transition(passengerButton, imgPassenger);
        setUI("passenger_form.fxml");

    }

    @FXML
    void salaryButtonOnAction(ActionEvent event) throws IOException {
        transition(salaryButton, imgSalary);
        setUI("salary_form.fxml");

    }

    @FXML
    void scheduleButtonOnAction(ActionEvent event) throws IOException {
        transition(scheduleButton, imgSchedule);
        setUI("trainShedule_form.fxml");

    }

    @FXML
    void ticketButtonOnAction(ActionEvent event) throws IOException {
        transition(ticketButton, imgTicket);
        setUI("ticket_form.fxml");
    }

    private void setUI(String fileName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/" + fileName));
        Pane registerPane = fxmlLoader.load();

        try {
            changePane.getChildren().clear();
            changePane.getChildren().setAll(registerPane);
            System.gc();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    @FXML
    void trainButtonOnAction(ActionEvent event) throws IOException {
        transition(trainButton, imgTrain);
        setUI("train_form.fxml");

    }

    RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1), imgSetting);





    @FXML
    void btnSettingMoved(MouseEvent event) {
        new animatefx.animation.RotateIn(imgSetting).play();


    }


    @FXML
    void btnSettingExited(MouseEvent event) {
        transition();

    }
    void transition(){
        rotateTransition.stop();
    }
}
