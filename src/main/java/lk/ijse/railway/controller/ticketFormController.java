package lk.ijse.railway.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import lk.ijse.railway.bo.custom.impl.TicketBOImpl;
import lk.ijse.railway.dao.custom.BookingDAO;
import lk.ijse.railway.dao.custom.impl.BookingDAOImpl;
import lk.ijse.railway.dao.custom.impl.TicketDAOImpl;
import lk.ijse.railway.dao.custom.impl.TrainDAOImpl;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ticketFormController implements Initializable {
    @FXML
    private Label classLabel1;


    @FXML
    private Pane bookingPane;


    @FXML
    private Label lblTicket;


    @FXML
    private Pane ticketPane;

    @FXML
    private JFXComboBox<String> selectTrainCB;



    @FXML
    private Label classLabel2;

    @FXML
    private Label classLabel3;
    @FXML
    private JFXButton bookingButton;


    @FXML
    private Pane lblPane;

    @FXML
    private JFXButton ticketingButton;

    @FXML
    private AnchorPane mainPane;

    TicketBOImpl ticketBO = new TicketBOImpl();

    @FXML
    void selectTrainOnAction(ActionEvent event) {
        String idl = selectTrainCB.getValue();

        try {
            int class1 = ticketBO.search1class(idl);
            classLabel3.setText(String.valueOf(class1));
            int class2 = ticketBO.search2class(idl);
            classLabel2.setText(String.valueOf(class2));
            int class3 = ticketBO.search3class(idl);
            classLabel1.setText(String.valueOf(class3));

        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }

    }

    @FXML
    void bookingButtonOnAction(ActionEvent event) throws IOException {

        RotateTransition rotate = new RotateTransition(Duration.seconds(0.5), bookingPane);
        rotate.setAxis(Rotate.Y_AXIS);
        rotate.setFromAngle(0);
        rotate.setToAngle(90);
        ScaleTransition scale = new ScaleTransition(Duration.seconds(0.5), bookingPane);
        scale.setToX(0);
        SequentialTransition sequentialTransition = new SequentialTransition(rotate, scale);
        sequentialTransition.play();

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(500);
                Platform.runLater(() -> {
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/booking_form.fxml"));
                        Pane registerPane = fxmlLoader.load();

                        try {
                            mainPane.getChildren().clear();
                            mainPane.getChildren().setAll(registerPane);
                            System.gc();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        

    }

    @FXML
    void ticketingButtonOnAction(ActionEvent event) throws IOException {

        RotateTransition rotate = new RotateTransition(Duration.seconds(0.5), ticketPane);
        rotate.setAxis(Rotate.Y_AXIS);
        rotate.setFromAngle(0);
        rotate.setToAngle(90);
        ScaleTransition scale = new ScaleTransition(Duration.seconds(0.5), ticketPane);
        scale.setToX(0);
        SequentialTransition sequentialTransition = new SequentialTransition(rotate, scale);
        sequentialTransition.play();

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(500); // wait for 10 seconds
                Platform.runLater(() -> { // open new window in the JavaFX Application thread
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/ticketing_form.fxml"));
                        Pane registerPane = fxmlLoader.load();

                        try {
                            mainPane.getChildren().clear();
                            mainPane.getChildren().setAll(registerPane);
                            System.gc();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadLabels();
        loadSelectTrainCB();
        LoadPanes();
    }

    private void LoadPanes() {

        TranslateTransition tt = new TranslateTransition(Duration.seconds(1), ticketPane);
        tt.setFromX(800);
        tt.setToX(0);
        tt.play();

        TranslateTransition ttt = new TranslateTransition(Duration.seconds(1), bookingPane);
        ttt.setFromX(800);
        ttt.setToX(0);
        ttt.play();

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.5), lblPane);
        scaleTransition.setFromX(0);
        scaleTransition.setFromY(0);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.play();

    }

    private void loadSelectTrainCB() {
        try {
            ObservableList<String> obList = FXCollections.observableArrayList();
            List<String> ids = ticketBO.loadtrainIds();

            for (String id : ids) {
                obList.add(id);
            }
            selectTrainCB.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }

    private void loadLabels() {

    }
}
