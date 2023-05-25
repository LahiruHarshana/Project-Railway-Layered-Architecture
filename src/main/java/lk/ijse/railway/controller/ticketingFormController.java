package lk.ijse.railway.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.animation.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import lk.ijse.railway.Notification.Notification;
import lk.ijse.railway.dao.*;
import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.dto.*;
import lk.ijse.railway.util.AlertTypes;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.animation.KeyFrame;
import javafx.util.Duration;

public class ticketingFormController implements Initializable {

    @FXML
    private JFXComboBox<String> classTypeCB;

    @FXML
    private TextField userIDTextField;


    @FXML
    private Label DateLAbel;


    @FXML
    private Label lblTime;


    @FXML
    private JFXButton btnReport;




    @FXML
    private TextField howManyTextField;


    @FXML
    private JFXButton ticketAddButton;

    @FXML
    private TextField ticketIDTextField;



    @FXML
    private Label ticketPriceLabel;

    @FXML
    private TextField PaymentTextField;

    @FXML
    private JFXComboBox<String> ticketStationComboBox;

    @FXML
    private JFXComboBox<String> ticketTrainComboBox;


    @FXML
    private Pane ticketingPane;

    TrainDAOImpl trainDAO = new TrainDAOImpl();

    TicketDAOImpl ticketDAO = new TicketDAOImpl();
    PaymentDAOImpl paymentDAO  = new PaymentDAOImpl();

    StationDetailsDAOImpl stationDetailsDAO = new StationDetailsDAOImpl();

    StationDAOImpl stationDAO = new StationDAOImpl();

    @FXML
    void howManyTextFieldOnAction(ActionEvent event) {


    }
    void loadTime(){
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedTime = currentTime.format(formatter);
            lblTime.setText(formattedTime);
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Timeline.INDEFINITE);
        clock.play();
    }

    @FXML
    void ticketAddButtonOnAction(ActionEvent event) {


        String ticketID = ticketIDTextField.getText();
        String trainID = ticketTrainComboBox.getValue();
        String paymentID = PaymentTextField.getText();
        String date = DateLAbel.getText();
        double price = Double.parseDouble(ticketPriceLabel.getText());
        String classType = classTypeCB.getValue();
        String stationName = ticketStationComboBox.getValue();
        int howMany = Integer.parseInt(howManyTextField.getText());

        System.out.println(ticketID+trainID+stationName+classType);


        boolean isPlaced = false;
        try {
            isPlaced = paymentDAO.payemntTicket(ticketID, trainID, paymentID,date,price,classType,stationName,howMany);
            if(isPlaced) {
                Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION","Bought the ticket");
            } else {
                Notification.notification(AlertTypes.ERROR,"ERROR!","Something Happened");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Notification.notification(AlertTypes.ERROR,"ERROR!","Sql Error !");
        }

        loadTicketID();


    }

    @FXML
    void ticketStationComboBoxOnAction(ActionEvent event) {

    }

    @FXML
    void ticketTrainComboBoxOnAction(ActionEvent event) {
        String idl = ticketTrainComboBox.getValue();
        try {
            ObservableList<String> obList = FXCollections.observableArrayList();
            List<String> ids = stationDetailsDAO.searchById(idl);

            for (String id : ids) {
                obList.add(id);
            }
            ticketStationComboBox.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
            Notification.notification(AlertTypes.ERROR,"Error! ","Combo Box Not Loaded !");
        }


    }



    public void handleKeyTyped(KeyEvent keyEvent) {

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(howManyTextField.getText());

        if (matcher.matches()) {
            howManyTextField.setStyle("-fx-background-radius: 7; -fx-border-radius: 7;-fx-border-width: 1px; -fx-border-color: #0b4874;-fx-background-color: rgba(0,0,0,0);");


        }else {
            howManyTextField.setStyle("-fx-background-radius: 7; -fx-border-radius: 7;-fx-border-width: 1.5px; -fx-border-color: red;-fx-background-color: rgba(0,0,0,0);");
            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(50), howManyTextField);
            translateTransition.setFromX(0);
            translateTransition.setToX(10);
            translateTransition.setCycleCount(10);
            translateTransition.setAutoReverse(true);

            translateTransition.play();
        }

        double distance = 0;
        String classType = classTypeCB.getValue();
        int classValue = 0;

        if (classType.equals("2ndClass")){
            classValue = 2;

        }if (classType.equals("3rdClass")){
            classValue =1;
        }


        String name = ticketStationComboBox.getValue();

        try {
            Ticket ticket = stationDAO.searchById(name);
             distance = ticket.getDistance();
            System.out.println(distance);
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }

        int how = Integer.parseInt(howManyTextField.getText());

        int price = (int) (distance*4*how*classValue);


        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
        ticketPriceLabel.setText(String.valueOf(price));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadTrainCB();
        loadTicketID();
        loadDate();
        LoadClassTypeCB();
        loadTime();
        LoadPane();
    }

    private void LoadPane() {
//        Timeline timeline = new Timeline();
//
//        // add a keyframe with a duration and a target value
//        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), new KeyValue(ticketingPane.opacityProperty(), 0.0));
//
//        // add the keyframe to the timeline
//        timeline.getKeyFrames().add(keyFrame);
//
//        // set the timeline to play
//        timeline.play();

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), ticketingPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();

//        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), ticketingPane);
//        translateTransition.setFromX(-ticketingPane.getWidth());
//        translateTransition.setToX(0);
//        translateTransition.play();
//
//        TranslateTransition slideIn = new TranslateTransition(Duration.seconds(0.5), ticketingPane);
//        slideIn.setFromX(600);  // Starting x position of the new window
//        slideIn.setToX(0);      // Ending x position of the new window
//        slideIn.play();

//        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.5), ticketingPane);
//        scaleTransition.setFromX(0);
//        scaleTransition.setFromY(0);
//        scaleTransition.setToX(1);
//        scaleTransition.setToY(1);
//        scaleTransition.play();
//
//
//        ParallelTransition parallelTransition = new ParallelTransition();
//        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), ticketingPane);
//        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.5), ticketingPane);
//        scaleTransition.setFromX(0);
//        scaleTransition.setFromY(0);
//        scaleTransition.setToX(1);
//        scaleTransition.setToY(1);
//        parallelTransition.getChildren().addAll(fadeTransition, scaleTransition);
//        parallelTransition.play();

//
//        TranslateTransition tt = new TranslateTransition(Duration.seconds(0.5), ticketingPane);
//        tt.setFromY(ticketingPane.getHeight());
//        tt.setToY(0);
//        FadeTransition ft = new FadeTransition(Duration.seconds(0.5), ticketingPane);
//        ft.setFromValue(0);
//        ft.setToValue(1);
//        ParallelTransition pt = new ParallelTransition(tt, ft);
//        pt.play();

        //===========================================================

//        RotateTransition rotate = new RotateTransition(Duration.seconds(0.5), ticketingPane);
//        rotate.setAxis(Rotate.Y_AXIS);
//        rotate.setFromAngle(0);
//        rotate.setToAngle(90);
//
//// create the scale transition
//        ScaleTransition scale = new ScaleTransition(Duration.seconds(0.5), ticketingPane);
//        scale.setToX(0);
//        scale.setOnFinished(event -> {
//            // open the new window here
//        });
//
//// create a sequential transition that combines the rotate and scale transitions
//        SequentialTransition sequentialTransition = new SequentialTransition(rotate, scale);
//        sequentialTransition.play();



       // =============================================================


//        RotateTransition rotateTransition = new RotateTransition(Duration.millis(1000), ticketingPane);
//        rotateTransition.setByAngle(360);
//        rotateTransition.setCycleCount(1);
//
//// create the Fade Transition
//        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), ticketingPane);
//        fadeTransition.setFromValue(0.0);
//        fadeTransition.setToValue(1.0);
//        fadeTransition.setCycleCount(1);
//
//// create the Parallel Transition
//        ParallelTransition parallelTransition = new ParallelTransition();
//        parallelTransition.getChildren().addAll(rotateTransition, fadeTransition);
//
//// create the new window
//
//
//// show the new window with the Rotate Transition and Fade Transition
//        parallelTransition.play();
//






    }

    private void LoadClassTypeCB() {
        try {
            ObservableList<String> obList = FXCollections.observableArrayList();


            obList.add("2ndClass");
            obList.add("3rdClass");

            classTypeCB.setItems(obList);
        } catch (Exception e) {
            e.printStackTrace();
            Notification.notification(AlertTypes.ERROR,"ERROR!","Combo Box Not Loaded !");
        }
    }

    private void loadDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        DateLAbel.setText(formattedDate);
    }

    private void loadTicketID() {

        try {
            int id = ticketDAO.search();
                int idl = id+1;


                ticketIDTextField.setText(String.valueOf(idl));



        } catch (SQLException e) {
            Notification.notification(AlertTypes.ERROR,"ERROR!","Id Is Not Found !");
        }

    }

    private void loadTrainCB() {
        try {
            ObservableList<String> obList = FXCollections.observableArrayList();
            List<String> ids = trainDAO.loadTrainIds();

            for (String id : ids) {
                obList.add(id);
            }
            ticketTrainComboBox.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
            Notification.notification(AlertTypes.ERROR,"ERROR !","Sql Error !");
        }
    }


    @FXML
    void btnClearOnAction(ActionEvent event) {
        howManyTextField.setText("");
        PaymentTextField.setText("");


    }



    @FXML
    void btnReportOnAction(ActionEvent event) throws SQLException {
        System.out.println("hi");
        try {
            JasperDesign jasperDesign = JRXmlLoader.load("src/main/resources/Reports/TicketReport.jrxml");
            JRDesignQuery query = new JRDesignQuery();
            query.setText("SELECT * FROM Ticket WHERE TicketID ="+ticketIDTextField.getText()+"");
            jasperDesign.setQuery(query);

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint);
        }catch (JRException e){
            e.printStackTrace();
        }
    }
}
