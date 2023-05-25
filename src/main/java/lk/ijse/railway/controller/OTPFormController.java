package lk.ijse.railway.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class OTPFormController implements Initializable {

    public static String name;
    public static String num;

    public static String address;

    public static String email;

    public static int randNum;

    public static signUpPasswordFormController sign = new signUpPasswordFormController();



    @FXML
    private AnchorPane Paneee;


    private Pane registerPane;

    @FXML
    private TextField txtOtp;

    public void otpFormController(String text, String text1, String text2, String text3) {
        name =text;
        num = text1;
        address = text2;
        email = text3;

    }

    public void randNum(int randNum) {
        this.randNum = randNum;

    }

    @FXML
    void btnBackOnAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/signUp_form.fxml"));
            registerPane = fxmlLoader.load();
            Paneee.getChildren().clear();
            Paneee.getChildren().setAll(registerPane);
            System.gc();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnNextOnAction(ActionEvent event) {



        int rand = Integer.parseInt(txtOtp.getText());

        if (rand==randNum){

            sign.values(name,num,address,email);

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/signUpPassword_form.fxml"));
                registerPane = fxmlLoader.load();
                Paneee.getChildren().clear();
                Paneee.getChildren().setAll(registerPane);
                System.gc();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }



    }

    void getValues(){



    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(name);
        System.out.println(randNum);
    }
}
