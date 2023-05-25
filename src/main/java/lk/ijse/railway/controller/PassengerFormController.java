package lk.ijse.railway.controller;

import animatefx.animation.RotateOutDownLeft;
import com.jfoenix.controls.JFXButton;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import lk.ijse.railway.Notification.Notification;
import lk.ijse.railway.dto.Passenger;
import lk.ijse.railway.dao.PassengerDAOImpl;
import lk.ijse.railway.util.AlertTypes;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassengerFormController implements Initializable {
    @FXML
    private TextField addressTextField;
    @FXML
    private JFXButton serchButton;
    @FXML
    private TextField contactNumberTextField;
    @FXML
    private JFXButton deleteButton;
    @FXML
    private Pane passengerPane;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField nicTextField;
    @FXML
    private TextField passengerIDTextField;
    @FXML
    private JFXButton searchButton;
    @FXML
    private JFXButton updateButton;
    @FXML
    private TextField textBookingID;
    PassengerDAOImpl passengerDAO = new PassengerDAOImpl();
    @FXML
    void deleteButtonOnAction(ActionEvent event) {

    }

    @FXML
    void searchButtonOnAction(ActionEvent event) {

        try {
            Passenger passenger = passengerDAO.searchPassenger(passengerIDTextField.getText());
            if (passenger != null) {
                passengerIDTextField.setText(passenger.getId());
                nameTextField.setText(passenger.getName());
                nicTextField.setText(passenger.getNic());
                addressTextField.setText(passenger.getAddress());
                contactNumberTextField.setText(passenger.getContact());
                emailTextField.setText(passenger.getEmail());
                textBookingID.setText(passenger.getBookinId());


            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "something happened!").show();
        }

    }


    @FXML
    void updateButtonOnAction(ActionEvent event) throws SQLException {
        int validation = 0;



        Pattern pattern = Pattern.compile("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,3})+$");
        Matcher matcher = pattern.matcher(emailTextField.getText());

        if (matcher.matches()) {
            emailTextField.setStyle("-fx-background-radius: 7; -fx-border-radius: 7;-fx-border-width: 1px; -fx-border-color: #0b4874;-fx-background-color: rgba(0,0,0,0);");



        } else {
            emailTextField.setStyle("-fx-background-radius: 7; -fx-border-radius: 7;-fx-border-width: 1.5px; -fx-border-color: red;-fx-background-color: rgba(0,0,0,0);");
            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(50), emailTextField);
            translateTransition.setFromX(0);
            translateTransition.setToX(10);
            translateTransition.setCycleCount(10);
            translateTransition.setAutoReverse(true);

            translateTransition.play();
            validation=1;

        }

        Pattern pattern2 = Pattern.compile("^(\\+\\d{1,3})?\\d{10}$");
        Matcher matcher2 = pattern2.matcher(contactNumberTextField.getText());

        if (matcher2.matches()) {
            contactNumberTextField.setStyle("-fx-background-radius: 7; -fx-border-radius: 7;-fx-border-width: 1px; -fx-border-color: #0b4874;-fx-background-color: rgba(0,0,0,0);");


        } else {
            contactNumberTextField.setStyle("-fx-background-radius: 7; -fx-border-radius: 7;-fx-border-width: 1.5px; -fx-border-color: red;-fx-background-color: rgba(0,0,0,0);");
            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(50), contactNumberTextField);
            translateTransition.setFromX(0);
            translateTransition.setToX(10);
            translateTransition.setCycleCount(10);
            translateTransition.setAutoReverse(true);

            translateTransition.play();

            validation=1;


        }
        if (validation==0) {

            String id = passengerIDTextField.getText();
            String name = nameTextField.getText();
            String bookingID = textBookingID.getText();
            String contact = contactNumberTextField.getText();
            String email = emailTextField.getText();
            String address = addressTextField.getText();
            String nic = nicTextField.getText();

            Passenger passenger = new Passenger(id, name, bookingID, contact, email, address, nic);

            boolean isUpdated = passengerDAO.update(passenger);
            System.out.println(isUpdated);
            if (isUpdated) Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Passenger Updated !");
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Duration duration = Duration.seconds(0.5);
        SequentialTransition seqTransition = new SequentialTransition();
        TranslateTransition translate1 = new TranslateTransition(Duration.seconds(0.25), passengerPane);
        translate1.setFromX(0);
        translate1.setToX(-20);
        TranslateTransition translate2 = new TranslateTransition(Duration.seconds(0.25), passengerPane);
        translate2.setFromX(-20);
        translate2.setToX(0);
        seqTransition.getChildren().addAll(translate1, translate2);
        seqTransition.setCycleCount(1);
        seqTransition.setAutoReverse(false);
        seqTransition.play();

        LoadTable();

    }
    @FXML
    void btnClearOnAction(ActionEvent event) {
        textBookingID.setText("");
        nicTextField.setText("");
        nameTextField.setText("");
        contactNumberTextField.setText("");
        emailTextField.setText("");
        addressTextField.setText("");
        passengerIDTextField.setText("");

    }

    private void LoadTable() {


    }

    public static void animate(Pane pane, Duration duration) {
        RotateTransition rt = new RotateTransition(duration, pane);
        rt.setAxis(Rotate.Z_AXIS);
        rt.setFromAngle(90);
        rt.setToAngle(0);
        rt.setCycleCount(1);

        // Create Timeline and KeyFrames
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(pane.opacityProperty(), 0);
        KeyFrame kf = new KeyFrame(Duration.ZERO, kv);
        timeline.getKeyFrames().add(kf);
        KeyValue kv2 = new KeyValue(pane.opacityProperty(), 1);
        KeyFrame kf2 = new KeyFrame(duration, kv2);
        timeline.getKeyFrames().add(kf2);

        // Play RotateTransition and Timeline together
        rt.play();
        timeline.play();
    }
    public void animatePane(Pane pane, Duration duration) {
        RotateOutDownLeft animation = new RotateOutDownLeft(pane);
        animation.setCycleDuration(1);
        animation.play();
    }
    public static void animation(Pane pane, Duration duration) {
        RotateTransition rotateTransition = new RotateTransition(duration, pane);
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(-90);
        rotateTransition.play();
    }
    public static void aaa(Pane pane, Duration duration) {
        FadeTransition ft = new FadeTransition(duration, pane);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }
    public static void fadeOut(Pane pane, Duration duration) {
        FadeTransition fadeOut = new FadeTransition(duration, pane);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.play();
    }
}




