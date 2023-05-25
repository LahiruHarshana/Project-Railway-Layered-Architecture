package lk.ijse.railway.controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signUpFormController implements Initializable {

    public static OTPFormController otpFormController = new OTPFormController();


    private String name;
    private String num;
    private String address;
    private String email;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblNumber;


    void values(){
        setName(txtName.getText());
        setNum(txtNum.getText());
        setAddress(txtAddress.getText());
        setEmail(txtEmail.getText());
    }

    @FXML
    void btnBackOnaction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/loginPage_form.fxml"));
            registerPane = fxmlLoader.load();
            anchor.getChildren().clear();
            anchor.getChildren().setAll(registerPane);
            System.gc();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }


    @FXML
    private AnchorPane anchor;
    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtEmail;

    private Pane registerPane;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNum;

    @FXML
    void btnNextOnAction(ActionEvent event) {

        int validation = 0;

        Pattern pattern = Pattern.compile("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,3})+$");
        Matcher matcher = pattern.matcher(txtEmail.getText());



        if (matcher.matches()) {
            txtEmail.setStyle("-fx-background-radius: 7;-fx-border-width: 0 0 2 0; -fx-border-color: white;-fx-background-color: rgba(0,0,0,0);");



        } else {
            txtEmail.setStyle("-fx-background-radius: 7;-fx-border-width: 0 0 2 0; -fx-border-color: red;-fx-background-color: rgba(0,0,0,0);");
            lblEmail.setVisible(true);
            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(50), txtEmail);
            translateTransition.setFromX(0);
            translateTransition.setToX(10);
            translateTransition.setCycleCount(10);
            translateTransition.setAutoReverse(true);

            translateTransition.play();

            TranslateTransition transition = new TranslateTransition(Duration.millis(50), lblEmail);
            transition.setFromX(0);
            transition.setToX(10);
            transition.setCycleCount(10);
            transition.setAutoReverse(true);

            transition.play();

            validation=1;

        }
        Pattern pattern2 = Pattern.compile("^(\\+\\d{1,3})?\\d{10}$");
        Matcher matcher2 = pattern2.matcher(txtNum.getText());

        if (matcher2.matches()) {
            txtNum.setStyle("-fx-background-radius: 7;-fx-border-width: 0 0 2 0; -fx-border-color: white;-fx-background-color: rgba(0,0,0,0);");


        } else {
            txtNum.setStyle("-fx-background-radius: 7;-fx-border-width: 0 0 2 0; -fx-border-color: red;-fx-background-color: rgba(0,0,0,0);");
            lblNumber.setVisible(true);

            TranslateTransition transition = new TranslateTransition(Duration.millis(50), lblNumber);
            transition.setFromX(0);
            transition.setToX(10);
            transition.setCycleCount(10);
            transition.setAutoReverse(true);

            transition.play();

            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(50), txtNum);
            translateTransition.setFromX(0);
            translateTransition.setToX(10);
            translateTransition.setCycleCount(10);
            translateTransition.setAutoReverse(true);

            translateTransition.play();

            validation=1;


        }
        if (validation==0) {

            otpFormController.otpFormController(txtName.getText(), txtNum.getText(), txtAddress.getText(), txtEmail.getText());
            sendOTP.sendOtp(txtName.getText(), txtEmail.getText());


            System.out.println("hi");

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/otp_form.fxml"));
                registerPane = fxmlLoader.load();
                anchor.getChildren().clear();
                anchor.getChildren().setAll(registerPane);
                System.gc();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }




    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        values();

    }
}
