package lk.ijse.railway.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import lk.ijse.railway.Notification.Notification;
import lk.ijse.railway.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.railway.dto.Employee;
import lk.ijse.railway.dto.tm.EmployeeTM;
import lk.ijse.railway.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.railway.model.EmployeeDTO;
import lk.ijse.railway.util.AlertTypes;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeFormController implements Initializable {
    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnUpdate;



    @FXML
    private TableView<EmployeeTM> tblEmployee;


    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colDob;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colNum;

    @FXML
    private TextField textAddress;

    @FXML
    private TextField textContact;

    @FXML
    private TextField textId;

    @FXML
    private TextField textName;
    @FXML
    private Pane employeePane;


    @FXML
    private TextField textDOB;


    @FXML
    private DatePicker pickerDob;

    EmployeeBOImpl employeeBO = new EmployeeBOImpl();
    @FXML
    void btnAddOnAction(ActionEvent event) {

        int validation = 0;


        Pattern pattern2 = Pattern.compile("^(\\+\\d{1,3})?\\d{10}$");
        Matcher matcher2 = pattern2.matcher(textContact.getText());

        if (matcher2.matches()) {
            textContact.setStyle("-fx-background-radius: 7; -fx-border-radius: 7;-fx-border-width: 1px; -fx-border-color: #0b4874;-fx-background-color: rgba(0,0,0,0);");


        } else {
            textContact.setStyle("-fx-background-radius: 7; -fx-border-radius: 7;-fx-border-width: 1.5px; -fx-border-color: red;-fx-background-color: rgba(0,0,0,0);");
            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(50), textContact);
            translateTransition.setFromX(0);
            translateTransition.setToX(10);
            translateTransition.setCycleCount(10);
            translateTransition.setAutoReverse(true);

            translateTransition.play();

            validation = 1;


        }
        if (validation==0) {
            String id = textId.getText();
            String name = textName.getText();
            Date date = Date.valueOf(pickerDob.getValue());
            String contact = textContact.getText();
            String address = textAddress.getText();

            Employee employee = new Employee(id, name, date, contact, address);

            try {
                boolean isSaved = employeeBO.save(employee);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Item saved!").show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
            }
            LoadTable();
            setCellValueFactory();
        }

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String code = textId.getText();
        try {
            boolean isDeleted = employeeBO.delete(code);
            if (isDeleted) {
                Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Deleted !");

            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
        }
        LoadTable();
        setCellValueFactory();

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        try {
            EmployeeDTO employee = employeeBO.search(textId.getText());
            if (employee != null) {
                textId.setText(employee.getId());
                textName.setText(employee.getName());
                pickerDob.setValue(employee.getDob().toLocalDate());
                textContact.setText(employee.getContact());
                textAddress.setText(employee.getAddress());


            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "something happened!").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        int validation = 0;

        Pattern pattern2 = Pattern.compile("^(\\+\\d{1,3})?\\d{10}$");
        Matcher matcher2 = pattern2.matcher(textContact.getText());

        if (matcher2.matches()) {
            textContact.setStyle("-fx-background-radius: 7; -fx-border-radius: 7;-fx-border-width: 1px; -fx-border-color: #0b4874;-fx-background-color: rgba(0,0,0,0);");


        } else {
            textContact.setStyle("-fx-background-radius: 7; -fx-border-radius: 7;-fx-border-width: 1.5px; -fx-border-color: red;-fx-background-color: rgba(0,0,0,0);");
            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(50), textContact);
            translateTransition.setFromX(0);
            translateTransition.setToX(10);
            translateTransition.setCycleCount(10);
            translateTransition.setAutoReverse(true);

            translateTransition.play();
            validation = 1;


        }

        if (validation==0) {

            String id = textId.getText();
            String name = textName.getText();
            Date date = Date.valueOf(pickerDob.getValue());
            String contact = textContact.getText();
            String address = textAddress.getText();

            Employee employee = new Employee(id, name, date, contact, address);

            try {
                boolean isUpdated = employeeBO.update(employee);
                if (isUpdated) {
                    Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","EmployeeDTO is updated!");

                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
            }
            LoadTable();
            setCellValueFactory();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoadTable();
        setCellValueFactory();
        LoadPane();
    }

    private void LoadPane() {

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.5), employeePane);
        scaleTransition.setFromX(0);
        scaleTransition.setFromY(0);
        scaleTransition.setToX(1);
        scaleTransition.setToY(1);
        scaleTransition.play();
    }
    private void LoadTable() {
        try {
            ObservableList<EmployeeTM> obList = FXCollections.observableArrayList();
            List<Employee> cusList = employeeBO.getAll();

            for (Employee employee : cusList) {
                obList.add(new EmployeeTM(
                        employee.getId(),
                        employee.getName(),
                        employee.getDob(),
                        employee.getContact(),
                        employee.getAddress()
                ));
            }
            tblEmployee.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        textId.setText("");
        textAddress.setText("");
        textContact.setText("");
        textDOB.setText("");
        textName.setText("");

    }
    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colNum.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
    }


}
