package lk.ijse.railway.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.ijse.railway.Notification.Notification;
import lk.ijse.railway.dto.User;
import lk.ijse.railway.dao.UserDAOImpl;
import lk.ijse.railway.util.AlertTypes;

import java.sql.SQLException;

public class signUpPasswordFormController {

    public static String Name;
    public static String Num;
    public static String Address;
    public static String Email;
    public static String pswd;

    public static int uID;

    private Pane registerPane;
    @FXML
    private PasswordField txtConfirmPswd;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private PasswordField txtPswd;

    UserDAOImpl userDAO = new UserDAOImpl();

    @FXML
    void btnRegisterOnAction(ActionEvent event) {

        if (txtPswd.getText().equals(txtConfirmPswd.getText())){
            try {
                int id = userDAO.search();
                int idl = id+1;

                 uID = idl;

                 pswd = txtPswd.getText();



            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "wrong").show();
            }


            User user = new User(uID,Name,pswd, Num,Address,Email);

            try {
                boolean isSaved = userDAO.save(user);
                if (isSaved) {
                    Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Registered Successfull !");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
            }
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/loginPage_form.fxml"));
                registerPane = fxmlLoader.load();
                anchorPane.getChildren().clear();
                anchorPane.getChildren().setAll(registerPane);
                System.gc();
            } catch (Exception e) {
                e.printStackTrace();
            }



        }

    }


    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/otp_form.fxml"));
            registerPane = fxmlLoader.load();
            anchorPane.getChildren().clear();
            anchorPane.getChildren().setAll(registerPane);
            System.gc();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void values(String name, String num, String address, String email) {
        Name = name;
        Num = num;
        Address = address;
        Email = email;

    }
}
