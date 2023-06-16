package lk.ijse.railway.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.railway.bo.BOFactory;
import lk.ijse.railway.bo.custom.LoginHistoryBO;
import lk.ijse.railway.bo.custom.impl.LoginBOImpl;
import lk.ijse.railway.bo.custom.impl.LoginHistoryBOImpl;
import lk.ijse.railway.dao.DAOFactory;
import lk.ijse.railway.dto.LoginHistory;
import lk.ijse.railway.dto.tm.LoginHistoryTM;
import lk.ijse.railway.dao.custom.impl.LoginHistoryDAOImpl;
import lk.ijse.railway.model.LoginHistoryDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class LogHistoryFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colLogOutDate;

    @FXML
    private TableColumn<?, ?> colLogOutTime;

    @FXML
    private TableColumn<?, ?> colLoginDate;


    @FXML
    private TableColumn<?, ?> colLoginTime;

    @FXML
    private TableView<LoginHistoryTM> tblLoginHistory;

    LoginHistoryBO loginHistoryBO = (LoginHistoryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.LOGINHISTORY);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        LoadTable();
    }

    private void LoadTable() {
        try {
            ObservableList<LoginHistoryTM> obList = FXCollections.observableArrayList();
            List<LoginHistoryDTO> cusList = loginHistoryBO.getAll();

            System.out.println("hi");

            for (LoginHistoryDTO loginHistory : cusList) {
                obList.add(new LoginHistoryTM(
                        loginHistory.getUId(),
                        loginHistory.getLogInDate(),
                        loginHistory.getLogInTime(),
                        loginHistory.getLogOutDate(),
                        loginHistory.getLogOutTime()
                ));
            }
            tblLoginHistory.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }


    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("uId"));
        colLoginDate.setCellValueFactory(new PropertyValueFactory<>("logInDate"));
        colLoginTime.setCellValueFactory(new PropertyValueFactory<>("LogInTime"));
        colLogOutDate.setCellValueFactory(new PropertyValueFactory<>("LogOutDate"));
        colLogOutTime.setCellValueFactory(new PropertyValueFactory<>("LogOutTime"));
    }
}
