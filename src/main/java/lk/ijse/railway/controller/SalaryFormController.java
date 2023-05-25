package lk.ijse.railway.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import lk.ijse.railway.Notification.Notification;
import lk.ijse.railway.dto.Employee;
import lk.ijse.railway.dto.Salary;
import lk.ijse.railway.dao.EmployeeDAOImpl;
import lk.ijse.railway.dao.SalaryModel;
import lk.ijse.railway.util.AlertTypes;


import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class SalaryFormController implements Initializable {
    @FXML
    private JFXButton btnSalary;

    @FXML
    private TextField txtName;

    @FXML
    private JFXButton btnSearch;
    @FXML
    private Pane paneSalary;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtRs;

    @FXML
    private TextField txtsalaryId;



    @FXML
    void btnSalaryOnAction(ActionEvent event) {

        String id = txtsalaryId.getText();
        String empId = txtId.getText();
        Date date = Date.valueOf(txtDate.getText());
        Double amount = Double.valueOf(txtRs.getText());

         Salary salary = new Salary(id, empId, date,amount);

        try {
            boolean isSaved = SalaryModel.save(salary);
            if (isSaved) {
                Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Saved Successfull !");

            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
        }


    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        try {
            Employee employee = EmployeeDAOImpl.search(txtId.getText());
            if (employee != null) {
                txtId.setText(employee.getId());
                txtName.setText(employee.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "something happened!").show();
        }

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtDate.setText("");
        txtId.setText("");
        txtsalaryId.setText("");
        txtRs.setText("");
        txtName.setText("");

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoadPane();
        LoadDate();

    }

    private void LoadDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
        txtDate.setText(formattedDate);
    }

    private void LoadPane() {
        TranslateTransition tt = new TranslateTransition(Duration.seconds(0.5), paneSalary);
        tt.setFromY(paneSalary.getHeight());
        tt.setToY(0);
        FadeTransition ft = new FadeTransition(Duration.seconds(0.8), paneSalary);
        ft.setFromValue(0);
        ft.setToValue(1);
        ParallelTransition pt = new ParallelTransition(tt, ft);
        pt.play();
    }
}
