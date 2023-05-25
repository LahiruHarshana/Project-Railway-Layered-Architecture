package lk.ijse.railway.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import lk.ijse.railway.Notification.Notification;
import lk.ijse.railway.dao.BookingDAOImpl;
import lk.ijse.railway.dao.SeatsDAOImpl;
import lk.ijse.railway.util.AlertTypes;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class SeatsFormController implements Initializable {
    @FXML
    private Rectangle S1;

    @FXML
    private Rectangle S10;

    @FXML
    private Rectangle S11;

    @FXML
    private Rectangle S12;

    @FXML
    private Rectangle S13;

    @FXML
    private Rectangle S14;

    @FXML
    private Rectangle S15;

    @FXML
    private Rectangle S16;

    @FXML
    private Rectangle S17;

    @FXML
    private Rectangle S18;

    @FXML
    private Rectangle S19;

    @FXML
    private Rectangle S2;

    @FXML
    private Rectangle S20;

    @FXML
    private Rectangle S21;

    @FXML
    private Rectangle S22;

    @FXML
    private Rectangle S23;

    @FXML
    private Rectangle S24;

    @FXML
    private Rectangle S25;

    @FXML
    private Rectangle S26;

    @FXML
    private Rectangle S27;

    @FXML
    private Rectangle S28;

    @FXML
    private Rectangle S29;

    @FXML
    private Rectangle S3;

    @FXML
    private Rectangle S30;

    @FXML
    private Rectangle S31;

    @FXML
    private Rectangle S32;

    @FXML
    private Rectangle S33;

    @FXML
    private Rectangle S34;

    @FXML
    private Rectangle S35;

    @FXML
    private Rectangle S36;

    @FXML
    private Rectangle S37;

    @FXML
    private Rectangle S38;

    @FXML
    private Rectangle S39;

    @FXML
    private Rectangle S4;

    @FXML
    private Rectangle S40;

    @FXML
    private Rectangle S41;

    @FXML
    private Rectangle S42;

    @FXML
    private Rectangle S43;

    @FXML
    private Rectangle S44;

    @FXML
    private Rectangle S45;

    @FXML
    private Rectangle S46;

    @FXML
    private Rectangle S47;


    @FXML
     Rectangle seat;

    @FXML
    private Rectangle S48;

    @FXML
    private Rectangle S5;

    @FXML
    private Rectangle S6;

    @FXML
    private Rectangle S7;

    @FXML
    private Rectangle S8;

    @FXML
    private Rectangle S9;

    static String trainId;

    static Date datee;

    public static void setId(String idl, Date date) {
        trainId=idl;
        datee = date;
    }


    @FXML
    void s10Clicked(MouseEvent event) {
        String seatsId = S10.getId();
        BookingFormController.seatsGetValue(seatsId);
        S10.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s11Clicked(MouseEvent event) {
        String seatsId = S11.getId();
        BookingFormController.seatsGetValue(seatsId);
        S11.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s12Clicked(MouseEvent event) {
        String seatsId = S12.getId();
        BookingFormController.seatsGetValue(seatsId);
        S12.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s13Clicked(MouseEvent event) {
        String seatsId = S13.getId();
        BookingFormController.seatsGetValue(seatsId);
        S13.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s14Clicked(MouseEvent event) {
        String seatsId = S14.getId();
        BookingFormController.seatsGetValue(seatsId);
        S14.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s15Clicked(MouseEvent event) {
        String seatsId = S15.getId();
        BookingFormController.seatsGetValue(seatsId);
        S15.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s16Clicked(MouseEvent event) {
        String seatsId = S16.getId();
        BookingFormController.seatsGetValue(seatsId);
        S16.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s17Clicked(MouseEvent event) {
        String seatsId = S17.getId();
        BookingFormController.seatsGetValue(seatsId);
        S17.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s18Clicked(MouseEvent event) {
        String seatsId = S18.getId();
        BookingFormController.seatsGetValue(seatsId);
        S18.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s19Clicked(MouseEvent event) {
        String seatsId = S19.getId();
        BookingFormController.seatsGetValue(seatsId);
        S19.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s1Clicked(MouseEvent event) {
        String seatsId = S1.getId();
        BookingFormController.seatsGetValue(seatsId);
        S1.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s20Clicked(MouseEvent event) {
        String seatsId = S20.getId();
        BookingFormController.seatsGetValue(seatsId);
        S20.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s21Clicked(MouseEvent event) {
        String seatsId = S21.getId();
        BookingFormController.seatsGetValue(seatsId);
        S21.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s22Clicked(MouseEvent event) {
        String seatsId = S22.getId();
        BookingFormController.seatsGetValue(seatsId);
        S22.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s23Clicked(MouseEvent event) {
        String seatsId = S23.getId();
        BookingFormController.seatsGetValue(seatsId);
        S23.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s24Clicked(MouseEvent event) {
        String seatsId = S24.getId();
        BookingFormController.seatsGetValue(seatsId);
        S24.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s25Clicked(MouseEvent event) {
        String seatsId = S25.getId();
        BookingFormController.seatsGetValue(seatsId);
        S25.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s26Clicked(MouseEvent event) {
        String seatsId = S26.getId();
        BookingFormController.seatsGetValue(seatsId);
        S26.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s27Clicked(MouseEvent event) {
        String seatsId = S27.getId();
        BookingFormController.seatsGetValue(seatsId);
        S27.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s28Clicked(MouseEvent event) {
        String seatsId = S28.getId();
        BookingFormController.seatsGetValue(seatsId);
        S28.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s29Clicked(MouseEvent event) {
        String seatsId = S29.getId();
        BookingFormController.seatsGetValue(seatsId);
        S29.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s2Clicked(MouseEvent event) {
        String seatsId = S2.getId();
        BookingFormController.seatsGetValue(seatsId);
        S2.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s30Clicked(MouseEvent event) {
        String seatsId = S30.getId();
        BookingFormController.seatsGetValue(seatsId);
        S30.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s31Clicked(MouseEvent event) {
        String seatsId = S31.getId();
        BookingFormController.seatsGetValue(seatsId);
        S31.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s32Clicked(MouseEvent event) {
        String seatsId = S32.getId();
        BookingFormController.seatsGetValue(seatsId);
        S32.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s33Clicked(MouseEvent event) {
        String seatsId = S33.getId();
        BookingFormController.seatsGetValue(seatsId);
        S33.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s34Clicked(MouseEvent event) {
        String seatsId = S34.getId();
        BookingFormController.seatsGetValue(seatsId);
        S34.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s35Clicked(MouseEvent event) {
        String seatsId = S35.getId();
        BookingFormController.seatsGetValue(seatsId);
        S35.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s36Clicked(MouseEvent event) {
        String seatsId = S36.getId();
        BookingFormController.seatsGetValue(seatsId);
        S36.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s37Clicked(MouseEvent event) {
        String seatsId = S37.getId();
        BookingFormController.seatsGetValue(seatsId);
        S37.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s38Clicked(MouseEvent event) {
        String seatsId = S38.getId();
        BookingFormController.seatsGetValue(seatsId);
        S38.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s39Clicked(MouseEvent event) {
        String seatsId = S39.getId();
        BookingFormController.seatsGetValue(seatsId);
        S39.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s3Clicked(MouseEvent event) {
        String seatsId = S3.getId();
        BookingFormController.seatsGetValue(seatsId);
        S3.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s40Clicked(MouseEvent event) {
        String seatsId = S40.getId();
        BookingFormController.seatsGetValue(seatsId);
        S40.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s41Clicked(MouseEvent event) {
        String seatsId = S41.getId();
        BookingFormController.seatsGetValue(seatsId);
        S41.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s42Clicked(MouseEvent event) {
        String seatsId = S42.getId();
        BookingFormController.seatsGetValue(seatsId);
        S42.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s43Clicked(MouseEvent event) {
        String seatsId = S43.getId();
        BookingFormController.seatsGetValue(seatsId);
        S43.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s44Clicked(MouseEvent event) {
        String seatsId = S44.getId();
        BookingFormController.seatsGetValue(seatsId);
        S44.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s45Clicked(MouseEvent event) {
        String seatsId = S45.getId();
        BookingFormController.seatsGetValue(seatsId);
        S45.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s46Clicked(MouseEvent event) {
        String seatsId = S46.getId();
        BookingFormController.seatsGetValue(seatsId);
        S46.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s47Clicked(MouseEvent event) {
        String seatsId = S47.getId();
        BookingFormController.seatsGetValue(seatsId);
        S47.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s48Clicked(MouseEvent event) {
        String seatsId = S48.getId();
        BookingFormController.seatsGetValue(seatsId);
        S48.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s4Clicked(MouseEvent event) {
        String seatsId = S4.getId();
        BookingFormController.seatsGetValue(seatsId);
        S4.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s5Clicked(MouseEvent event) {
        String seatsId = S5.getId();
        BookingFormController.seatsGetValue(seatsId);
        S5.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s6Clicked(MouseEvent event) {
        String seatsId = S6.getId();
        BookingFormController.seatsGetValue(seatsId);
        S6.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s7Clicked(MouseEvent event) {
        String seatsId = S7.getId();
        BookingFormController.seatsGetValue(seatsId);
        S7.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s8Clicked(MouseEvent event) {
        String seatsId = S8.getId();
        BookingFormController.seatsGetValue(seatsId);
        S8.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");


    }

    @FXML
    void s9Clicked(MouseEvent event) {
        String seatsId = S9.getId();
        BookingFormController.seatsGetValue(seatsId);
        S9.setFill(Color.PINK);
        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Seat is Book Now !");

    }

    BookingDAOImpl bookingDAO = new BookingDAOImpl();






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            ObservableList<String> obList = FXCollections.observableArrayList();
            List<String> ids = bookingDAO.loadIds(trainId,datee);

            for (String id : ids) {
                if (id.equals("S1")){
                    S1.setFill(Color.PINK);
                }if (id.equals("S2")){
                    S2.setFill(Color.PINK);
                }if (id.equals("S3")){
                    S3.setFill(Color.PINK);
                }if (id.equals("S4")){
                    S4.setFill(Color.PINK);
                }if (id.equals("S5")){
                    S5.setFill(Color.PINK);
                }if (id.equals("S6")){
                    S6.setFill(Color.PINK);
                }if (id.equals("S7")){
                    S7.setFill(Color.PINK);
                }if (id.equals("S8")){
                    S8.setFill(Color.PINK);
                }if (id.equals("S9")){
                    S9.setFill(Color.PINK);
                }if (id.equals("S10")){
                    S10.setFill(Color.PINK);
                }if (id.equals("S11")){
                    S11.setFill(Color.PINK);
                }if (id.equals("S12")){
                    S12.setFill(Color.PINK);
                }if (id.equals("S13")){
                    S13.setFill(Color.PINK);
                }if (id.equals("S14")){
                    S14.setFill(Color.PINK);
                }if (id.equals("S15")) {
                    S15.setFill(Color.PINK);
                }if (id.equals("S16")){
                    S16.setFill(Color.PINK);
                }if (id.equals("S17")){
                    S17.setFill(Color.PINK);
                }if (id.equals("S18")){
                    S18.setFill(Color.PINK);
                }if (id.equals("S19")){
                    S19.setFill(Color.PINK);
                }if (id.equals("S20")){
                    S20.setFill(Color.PINK);
                }if (id.equals("S21")){
                    S21.setFill(Color.PINK);
                }if (id.equals("S22")){
                    S22.setFill(Color.PINK);
                }if (id.equals("S23")){
                    S23.setFill(Color.PINK);
                }if (id.equals("S24")){
                    S24.setFill(Color.PINK);
                }if (id.equals("S25")){
                    S25.setFill(Color.PINK);
                }if (id.equals("S26")){
                    S26.setFill(Color.PINK);
                }if (id.equals("S27")){
                    S27.setFill(Color.PINK);
                }if (id.equals("S28")){
                    S28.setFill(Color.PINK);
                }if (id.equals("S29")){
                    S29.setFill(Color.PINK);
                }if (id.equals("S30")){
                    S30.setFill(Color.PINK);
                }if (id.equals("S31")){
                    S31.setFill(Color.PINK);
                }if (id.equals("S32")){
                    S32.setFill(Color.PINK);
                }if (id.equals("S33")){
                    S33.setFill(Color.PINK);
                }if (id.equals("S34")){
                    S34.setFill(Color.PINK);
                }if (id.equals("S35")){
                    S35.setFill(Color.PINK);
                }if (id.equals("S36")){
                    S36.setFill(Color.PINK);
                }if (id.equals("S37")){
                    S37.setFill(Color.PINK);
                }if (id.equals("S38")){
                    S38.setFill(Color.PINK);
                }if (id.equals("S39")){
                    S39.setFill(Color.PINK);
                }if (id.equals("S40")){
                    S40.setFill(Color.PINK);
                }if (id.equals("S41")){
                    S41.setFill(Color.PINK);
                }if (id.equals("S42")){
                    S42.setFill(Color.PINK);
                }if (id.equals("S43")){
                    S43.setFill(Color.PINK);
                }if (id.equals("S44")){
                    S44.setFill(Color.PINK);
                }if (id.equals("S45")){
                    S45.setFill(Color.PINK);
                }if (id.equals("S46")){
                    S46.setFill(Color.PINK);
                }if (id.equals("S47")){
                    S47.setFill(Color.PINK);
                }if (id.equals("S48")){
                    S48.setFill(Color.PINK);
                }


                obList.add(id);
            }


        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }


}
