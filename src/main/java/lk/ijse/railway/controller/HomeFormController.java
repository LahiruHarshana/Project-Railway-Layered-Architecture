package lk.ijse.railway.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import lk.ijse.railway.Launcher;
import lk.ijse.railway.Notification.Notification;
import lk.ijse.railway.dto.LoginHistory;
import lk.ijse.railway.dao.LoginHistoryDAOImpl;
import lk.ijse.railway.util.AlertTypes;

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

    LoginHistoryDAOImpl loginHistoryDAO = new LoginHistoryDAOImpl();
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

            boolean isSaved = loginHistoryDAO.saveLogOut(uId,date,time1);
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
            LoginHistory loginHistory = LoginHistoryDAOImpl.searchLastID();
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
