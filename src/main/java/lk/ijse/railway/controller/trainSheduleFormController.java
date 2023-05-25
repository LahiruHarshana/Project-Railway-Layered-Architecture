package lk.ijse.railway.controller;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import lk.ijse.railway.dto.Train;
import lk.ijse.railway.dto.tm.TrainTM;
import lk.ijse.railway.dao.TrainModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class trainSheduleFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> colEndStation;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTime;

    @FXML
    private TableView<TrainTM> timeTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoadTable();
        setCellValueFactory();

        timeTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Create a new TranslateTransition that moves the row up and down repeatedly
                TranslateTransition tt = new TranslateTransition(Duration.millis(100), timeTable);
                tt.setByY(10);
                tt.setAutoReverse(true);
                tt.setCycleCount(4);
                tt.play();
            }
        });
    }

    private void LoadTable() {
        try {
            ObservableList<TrainTM> obList = FXCollections.observableArrayList();
            List<Train> cusList = TrainModel.getAll();

            for (Train train : cusList) {
                obList.add(new TrainTM(
                        train.getId(),
                        train.getName(),
                        train.getTime(),
                        train.getEndStation()
                ));
            }
            timeTable.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }

    }

    private void setCellValueFactory() {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("Time"));
        colEndStation.setCellValueFactory(new PropertyValueFactory<>("EndStation"));
    }

}
