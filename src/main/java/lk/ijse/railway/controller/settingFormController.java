package lk.ijse.railway.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lk.ijse.railway.Launcher;
import lk.ijse.railway.controller.util.Notification;
import lk.ijse.railway.bo.BOFactory;
import lk.ijse.railway.bo.custom.impl.SettingBOImpl;
import lk.ijse.railway.entity.LoginHistory;
import lk.ijse.railway.entity.User;
import lk.ijse.railway.model.LoginHistoryDTO;
import lk.ijse.railway.model.UserDTO;
import lk.ijse.railway.controller.util.AlertTypes;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class settingFormController implements Initializable {

    static int uId;

    @FXML
    private JFXButton btnEdit;

    @FXML
    private AnchorPane childPane;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNum;

    @FXML
    private TextField txtRoll;

    SettingBOImpl settingBO = (SettingBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SETTINGS);

    private void setUI(String fileName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/"+fileName));
        Pane registerPane = fxmlLoader.load();

        try {
            childPane.getChildren().clear();
            childPane.getChildren().setAll(registerPane);
            System.gc();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnChangePswdOnAction(ActionEvent event) throws IOException {
        setUI("changePassword_form.fxml");



    }

    @FXML
    void btnEditOnAction(ActionEvent event) {
         uId = Integer.parseInt(txtID.getText());
        String name = txtName.getText();
        String num = txtNum.getText();
        String address = txtRoll.getText();
        String email = txtEmail.getText();

        User user = new User( uId,name,num,address,email);

        try {
            boolean isUpdated = settingBO.update(user);
            if (isUpdated) {
                Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Updated Successfull !");
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
        }

    }

    @FXML
    void btnEditProfileOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/setting_form.fxml"));
        Pane registerPane = fxmlLoader.load();

        try {
            mainPane.getChildren().clear();
            mainPane.getChildren().setAll(registerPane);
            System.gc();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnLogHistoryOnAction(ActionEvent event) throws IOException {
        setUI("logHistory_form.fxml");

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws Exception {
        Launcher launcher = new Launcher();
        Stage stage = new Stage();
        launcher.start(stage);

        try {
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = currentDate.format(formatter);
            Date date = Date.valueOf(formattedDate);

            LocalTime time = LocalTime.now();
            Time time1 = Time.valueOf(time);

            boolean isSaved = settingBO.saveLogOut(new LoginHistory(uId,date,time1));
            if (isSaved) {
                Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Save Successfull !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
        }




    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoadTxts();
    }

    private void LoadTxts() {

        try {
            LoginHistoryDTO loginHistory = settingBO.searchLastID();
            if (loginHistory != null) {
                uId =loginHistory.getUId();
                System.out.println(uId);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "something happened!").show();
        }
        try {
            UserDTO user = settingBO.searchAll(uId);
            if (user != null) {
                txtID.setText(String.valueOf(user.getUId()));
                txtName.setText(user.getName());
                txtNum.setText(user.getNum());
                txtRoll.setText(user.getAddress());
                txtEmail.setText(user.getEmail());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "something happened!").show();
        }
    }
}
