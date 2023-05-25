package lk.ijse.railway.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.railway.Notification.Notification;
import lk.ijse.railway.dto.LoginHistory;
import lk.ijse.railway.dto.User;
import lk.ijse.railway.dao.UserDAOImpl;
import lk.ijse.railway.dao.LoginHistoryDAOImpl;
import lk.ijse.railway.util.AlertTypes;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ChangePasswordFormController implements Initializable {

    @FXML
    private TextField txtConfirm;

    public static int uId;
    public static String currentPswd;

    @FXML
    private TextField txtCurrentPswd;

    @FXML
    private TextField txtNew;

    @FXML
    void btnChangeOnAction(ActionEvent event) {

        if(txtCurrentPswd.getText().equals(currentPswd)){
            if (txtNew.getText().equals(txtConfirm.getText())){


                User user = new User( uId,txtConfirm.getText());

                try {
                    boolean isUpdated = UserDAOImpl.update1(user);
                    if (isUpdated) {
                        Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","User Updated!");
                    }
                } catch (SQLException e) {
                    new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
                }
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoadUId();
    }

    private void LoadUId() {
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
        try {
            User user = UserDAOImpl.searchAll(uId);
            if (user != null) {
                currentPswd = user.getPswd();

            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "something happened!").show();
        }
    }
}
