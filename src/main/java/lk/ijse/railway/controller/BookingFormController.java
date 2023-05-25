package lk.ijse.railway.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.railway.Notification.Notification;
import lk.ijse.railway.dao.*;
import lk.ijse.railway.db.DBConnection;
import lk.ijse.railway.dto.Ticket;
import lk.ijse.railway.util.AlertTypes;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//hi

public class BookingFormController implements Initializable {



    @FXML
    private TextField paymentIDTextField;
    @FXML
    private Label passengerLabel;
    @FXML
    private TextField AddressTextField;

    @FXML
    private TextField BookingIdTextField;

    @FXML
    private TextField ContactTextField;

    @FXML
    private Label CurrentDateLabel;

    @FXML
    private TextField NameTextField;

    @FXML
    private TextField NicTextField;

    @FXML
    private Label PriceLabel;

    @FXML
    private JFXButton SheetsButton;


    @FXML
    private Pane bookingPane;

    @FXML
    private JFXComboBox<String> StationNameCB;

    @FXML
    private TextField ToDateTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private JFXButton payButton;

    static String seat;

    @FXML
    private JFXComboBox<String > trainIdCB;

    public static void seatsGetValue(String seatsId) {
        seat = seatsId;

    }


    @FXML
    void SheetsButtonOnAction(ActionEvent event) throws IOException {
        String idl = trainIdCB.getValue();
        Date date = Date.valueOf(ToDateTextField.getText());
        SeatsFormController.setId(idl, date);

        Parent anchorPane =  FXMLLoader.load(getClass().getResource("/view/seats_form.fxml"));
        Scene scene = (new Scene(anchorPane));

        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);

        stage.show();
    }


    @FXML
    void btnClearOnAction(ActionEvent event) {

        emailTextField.setText("");
        NameTextField.setText("");
        paymentIDTextField.setText("");
        BookingIdTextField.setText("");
        ContactTextField.setText("");
        AddressTextField.setText("");
        NicTextField.setText("");
        ToDateTextField.setText("");
    }

    @FXML
    void StationNameCBOnAction(ActionEvent event) {
        double distance = 0;


        String name = StationNameCB.getValue();

        try {
            Ticket ticket = TicketingDAOImpl.searchById(name);
            distance = ticket.getDistance();
            System.out.println(distance);
        } catch (SQLException e) {
            e.printStackTrace();
            Notification.notification(AlertTypes.ERROR,"ERROR !","Sql Error !");
        }



        int price = (int) (distance*12);


        LocalDate currentDate = LocalDate.now();
        String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
        PriceLabel.setText(String.valueOf(price));

    }

    @FXML
    void payButtonOnAction(ActionEvent event) {
        int validation = 0;

        int value = 0;

        if(emailTextField.getText()==null || emailTextField.getText().isEmpty()){
            new Alert(Alert.AlertType.WARNING, "email is empty").show();
        }

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

        if(ToDateTextField.getText()==null || ToDateTextField.getText().isEmpty()){
            Notification.notification(AlertTypes.ERROR,"ERROR !","Date is empty !");
        }

        Pattern pattern1 = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})");
        Matcher matcher1 = pattern1.matcher(ToDateTextField.getText());



        if (matcher1.matches()) {
            ToDateTextField.setStyle("-fx-background-radius: 7; -fx-border-radius: 7;-fx-border-width: 1px; -fx-border-color: #0b4874;-fx-background-color: rgba(0,0,0,0);");



        } else {
            ToDateTextField.setStyle("-fx-background-radius: 7; -fx-border-radius: 7;-fx-border-width: 1.5px; -fx-border-color: red;-fx-background-color: rgba(0,0,0,0);");
            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(50), ToDateTextField);
            translateTransition.setFromX(0);
            translateTransition.setToX(10);
            translateTransition.setCycleCount(10);
            translateTransition.setAutoReverse(true);

            translateTransition.play();

            validation=1;

        }




        if(ContactTextField.getText()==null || ContactTextField.getText().isEmpty()){
            Notification.notification(AlertTypes.ERROR,"ERROR !","Contact Number is empty !");
        }

        Pattern pattern2 = Pattern.compile("^(\\+\\d{1,3})?\\d{10}$");
        Matcher matcher2 = pattern2.matcher(ContactTextField.getText());

        if (matcher2.matches()) {
            ContactTextField.setStyle("-fx-background-radius: 7; -fx-border-radius: 7;-fx-border-width: 1px; -fx-border-color: #0b4874;-fx-background-color: rgba(0,0,0,0);");


        } else {
            ContactTextField.setStyle("-fx-background-radius: 7; -fx-border-radius: 7;-fx-border-width: 1.5px; -fx-border-color: red;-fx-background-color: rgba(0,0,0,0);");
            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(50), ContactTextField);
            translateTransition.setFromX(0);
            translateTransition.setToX(10);
            translateTransition.setCycleCount(10);
            translateTransition.setAutoReverse(true);

            translateTransition.play();

            validation=1;


        }



        String bookingId = BookingIdTextField.getText();
        String date = CurrentDateLabel.getText();
        Date toDate = Date.valueOf(ToDateTextField.getText());
        String trainId = trainIdCB.getValue();
        String stationName = StationNameCB.getValue();
        String seatsId = seat;
        String paymentId = paymentIDTextField.getText();
        double price = Double.parseDouble(PriceLabel.getText());
        String passengerId = passengerLabel.getText();
        String passengerName = NameTextField.getText();
        String contactNum = ContactTextField.getText();
        String email = emailTextField.getText();
        String address = AddressTextField.getText();
        String Nic = NicTextField.getText();

        System.out.println(seatsId);



        boolean isPlaced = false;
        try {
            if (validation==0) {
                isPlaced = BookingDAOImpl.paymentBooking(bookingId, date, toDate, trainId, stationName, seatsId, paymentId, price, passengerId, passengerName, contactNum, email, address, Nic);
            }
            if(isPlaced) {
                value =1;
                validation=0;
                Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION","Booking is successful !");
            } else {
                Notification.notification(AlertTypes.ERROR,"ERROR !","Booking is unsuccessful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Notification.notification(AlertTypes.ERROR,"ERROR !","Sql Error 1");
        }

        if(value==1) {
            value=0;

            sendMail.send(bookingId, date, toDate, trainId, stationName, seatsId, price, email, passengerName);
        }

        LoadPassengerID();


    }

    @FXML
    void trainIDCBOnAction(ActionEvent event) {
        String idl = trainIdCB.getValue();
//        Date date = Date.valueOf(ToDateTextField.getText());
//        seatsFormController.setId(idl, date);
        try {
            ObservableList<String> obList = FXCollections.observableArrayList();
            List<String> ids = StationDetailsDAOImpl.searchById(idl);

            for (String id : ids) {
                obList.add(id);
            }
            StationNameCB.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }




    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoadTrainIDCB();
        LoadStationNameCB();
        LoadCurrentDate();
        LoadPassengerID();
        LoadPane();

    }

    private void LoadPane() {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), bookingPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }


    private void LoadPassengerID() {
        try {
            int id = PassengerDAOImpl.search();
            int idl = id+1;


            passengerLabel.setText(String.valueOf(idl));



        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "wrong").show();
        }
    }

    private void LoadCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        CurrentDateLabel.setText(formattedDate);
    }

    private void LoadStationNameCB() {

    }

    private void LoadTrainIDCB() {
        try {
            ObservableList<String> obList = FXCollections.observableArrayList();
            List<String> ids = TrainModel.loadIds();

            for (String id : ids) {
                obList.add(id);
            }
            trainIdCB.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }

    @FXML
    void btnResitOnAction(ActionEvent event) throws SQLException {
        try {
            JasperDesign jasperDesign = JRXmlLoader.load("src/main/resources/Reports/BookingResit.jrxml");
            JRDesignQuery query = new JRDesignQuery();
            query.setText("SELECT * FROM Booking WHERE BookingID ='"+BookingIdTextField.getText()+"'");
            jasperDesign.setQuery(query);

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint);
        }catch (JRException e){
            e.printStackTrace();
        }

    }
}
