package lk.ijse.railway.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.railway.dto.Train;
import lk.ijse.railway.dto.tm.TrainTM;
import lk.ijse.railway.dao.custom.impl.TrainDAOImpl;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class viewTrainsFormController implements Initializable {
    @FXML
    private JFXButton btnBack;

    @FXML
    private TableColumn<?, ?> colEndStation;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTime;

    @FXML
    private TableView<TrainTM> tblViewTrains;

    @FXML
    private AnchorPane viewTrain;

    TrainDAOImpl trainDAO = new TrainDAOImpl();

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        LoadTable();
        setCellValueFactory();
        TranslateTransition slideIn = new TranslateTransition(Duration.seconds(0.7), viewTrain);
        slideIn.setFromX(600);  // Starting x position of the new window
        slideIn.setToX(0);      // Ending x position of the new window
        slideIn.play();



        tblViewTrains.setRowFactory(tv -> {

            TableRow<TrainTM> row = new TableRow<>();
            tblViewTrains.getColumns().forEach(column -> {
                column.setStyle("-fx-background-color: rgba(0, 0, 0, 0.9);");
                column.setStyle("-fx-font-size: 17px;");
            });


            if (row.getIndex() % 2 == 0) {
                row.setStyle("-fx-background-color:#0FA3B1"); // Even rows
            } else {
                row.setStyle("-fx-background-color:#86CDD1");
            }            FadeTransition fadeTransition = new FadeTransition(Duration.millis(2200), row);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);

            TranslateTransition tt = new TranslateTransition(Duration.millis(900), row);
            tt.setFromY(-100); // Set the start position of the transition
            tt.setToY(0);

            fadeTransition.play();
            tt.play();
            return row;
        });


    }

    private void LoadTable() {
        try {
            ObservableList<TrainTM> obList = FXCollections.observableArrayList();
            List<Train> cusList = trainDAO.getAll();

            for (Train train : cusList) {
                obList.add(new TrainTM(
                        train.getId(),
                        train.getName(),
                        train.getTime(),
                        train.getEndStation()
                ));
            }
            tblViewTrains.setItems(obList);
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
