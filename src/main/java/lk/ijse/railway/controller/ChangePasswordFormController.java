package lk.ijse.railway.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.railway.controller.util.Notification;
import lk.ijse.railway.bo.BOFactory;
import lk.ijse.railway.bo.custom.ChangePasswordBO;
import lk.ijse.railway.entity.User;
import lk.ijse.railway.model.LoginHistoryDTO;
import lk.ijse.railway.model.UserDTO;
import lk.ijse.railway.controller.util.AlertTypes;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class  ChangePasswordFormController implements Initializable {

    @FXML
    private TextField txtConfirm;

    public static int uId;
    public static String currentPswd;

    @FXML
    private TextField txtCurrentPswd;

    @FXML
    private TextField txtNew;
    ChangePasswordBO changePasswordBO = (ChangePasswordBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CHANGEPSWD);
    @FXML
    void btnChangeOnAction(ActionEvent event) {

        if(txtCurrentPswd.getText().equals(currentPswd)){
            if (txtNew.getText().equals(txtConfirm.getText())){


                User user = new User( uId,txtConfirm.getText());

                try {
                    boolean isUpdated = changePasswordBO.updatePassword(user);
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
            LoginHistoryDTO loginHistory = changePasswordBO.searchLastID();
            if (loginHistory != null) {
                uId =loginHistory.getUId();
                System.out.println(uId);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "something happened!").show();
        }
        try {
            UserDTO user = changePasswordBO.searchAll(uId);
            if (user != null) {
                currentPswd = user.getPswd();

            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "something happened!").show();
        }
    }
}
