package lk.ijse.railway.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import lk.ijse.railway.Launcher;
import lk.ijse.railway.controller.util.Notification;
import lk.ijse.railway.bo.BOFactory;
import lk.ijse.railway.bo.custom.HomeBO;
import lk.ijse.railway.entity.LoginHistory;
import lk.ijse.railway.model.LoginHistoryDTO;
import lk.ijse.railway.controller.util.AlertTypes;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class HomeFormController implements Initializable {

    public static int uId;

    HomeBO homeBO = (HomeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.HOME);

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

            boolean isSaved = homeBO.saveLogOut(new LoginHistory(uId,date,time1));
            if (isSaved) {
                Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !"," Log out saved!");

            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            LoginHistoryDTO loginHistory = homeBO.searchLastID();
            if (loginHistory != null) {
                uId =loginHistory.getUId();
                System.out.println(uId);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "something happened!").show();
        }

    }
}
