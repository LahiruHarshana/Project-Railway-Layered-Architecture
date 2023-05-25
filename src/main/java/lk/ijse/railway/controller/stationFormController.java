package lk.ijse.railway.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.railway.Notification.Notification;
import lk.ijse.railway.dto.Station;
import lk.ijse.railway.dto.tm.StationTM;
import lk.ijse.railway.dao.StationDAOImpl;
import lk.ijse.railway.util.AlertTypes;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class stationFormController implements Initializable {

    @FXML
    private JFXButton btnDelete;


    @FXML
    private JFXButton addButton;

    @FXML
    private TextField distanceText;

    @FXML
    private TextField idText;

    @FXML
    private JFXButton searchButton;

    @FXML
    private TextField stationNameText;
    @FXML
    private TableColumn<?, ?> colDistance;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableView<StationTM> tblStations;


    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String code = idText.getText();
        try {
            boolean isDeleted = StationDAOImpl.delete(code);
            if (isDeleted) {
                Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Delete Successfull !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "something went wrong!").show();

        }
        LoadTable();
        setCellValueFactory();

    }


    @FXML
    void btnClearOnAction(ActionEvent event) {
        idText.setText("");
        stationNameText.setText("");
        distanceText.setText("");
    }




    @FXML
    void addButtonOnAction(ActionEvent event) {
        String id = idText.getText();
        String name = stationNameText.getText();
        double distance = Double.parseDouble(distanceText.getText());

        Station station = new Station(id,name,distance);

        try {
//            boolean isSaved = ItemModel.save(code, description, unitPrice, qtyOnHand);
            boolean isSaved = StationDAOImpl.save(station);
            if (isSaved) {
                Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","save Successfull !");
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
        }

        LoadTable();
        setCellValueFactory();

    }

    @FXML
    void searchButtonOnAction(ActionEvent event) {
        try {
            Station station = StationDAOImpl.search(idText.getText());
            if (station != null) {
                idText.setText(station.getId());
                stationNameText.setText(station.getName());
                distanceText.setText(String.valueOf(station.getDistance()));
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "something happened!").show();
        }

    }

    @FXML
    void updateButtonOnAction(ActionEvent event) {

        String id = idText.getText();
        String name = stationNameText.getText();
        double distance = Double.parseDouble(distanceText.getText());

        Station station = new Station(id,name,distance);


        try {
            boolean isUpdated = StationDAOImpl.update(station);
            Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Updated Successfull !");
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
        }

        LoadTable();
        setCellValueFactory();



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoadTable();
        setCellValueFactory();
    }

    private void LoadTable() {
        try {
            ObservableList<StationTM> obList = FXCollections.observableArrayList();
            List<Station> cusList = StationDAOImpl.getAll();

            for (Station station : cusList) {
                obList.add(new StationTM(
                        station.getId(),
                        station.getName(),
                        station.getDistance()
                ));
            }
            tblStations.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }
    private void setCellValueFactory() {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDistance.setCellValueFactory(new PropertyValueFactory<>("distance"));
    }
}
