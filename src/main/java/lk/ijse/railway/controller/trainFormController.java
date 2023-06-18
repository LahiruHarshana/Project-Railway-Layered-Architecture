package lk.ijse.railway.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.railway.controller.util.Notification;
import lk.ijse.railway.bo.BOFactory;
import lk.ijse.railway.bo.custom.impl.TrainBOImpl;
import lk.ijse.railway.entity.StationDetails;
import lk.ijse.railway.entity.Train;
import lk.ijse.railway.model.TrainDTO;
import lk.ijse.railway.controller.util.AlertTypes;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

public class trainFormController implements Initializable {

    @FXML
    private TextField idText;

    @FXML
    private Pane trainPane;

    @FXML
    private Pane trainAddStationPane;

    @FXML
    private JFXComboBox<String> TrainIDComboBox;
    @FXML
    private AnchorPane PaneStation;

    @FXML
    private JFXButton addStationButton;

    @FXML
    private JFXButton addTrainButton;

    @FXML
    private JFXButton deleteButton;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField journeyToTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private JFXButton searchButton;

    @FXML
    private JFXComboBox<String> stationNameComboBox;

    @FXML
    private TextField timeTextField;

    @FXML
    private JFXButton btnViewTrains;
    @FXML
    private TextField trainIDButton;

    @FXML
    private JFXButton btnDelete;
    @FXML
    private TextField EndStationTextField;

    @FXML
    private JFXButton updateButton;

    @FXML
    private JFXComboBox<?> wichComboBox;

    TrainBOImpl trainBO = (TrainBOImpl) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.TRAIN);


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadStationNameComboBox();
        loadTrainIDCB();
        loadPanes();

    }
    @FXML
    void btnClearOnAction(ActionEvent event) {
        trainIDButton.setText("");
        nameTextField.setText("");
        EndStationTextField.setText("");
        journeyToTextField.setText("");

    }


    @FXML
    void btnViewTrainsOnAction(ActionEvent event) throws IOException {
        Parent anchorPane =  FXMLLoader.load(getClass().getResource("/view/viewTrains_form.fxml"));
        Scene scene = (new Scene(anchorPane));

        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);

        stage.show();

    }


    private void loadPanes() {
        TranslateTransition slideIn = new TranslateTransition(Duration.seconds(0.7), trainPane);
        slideIn.setFromX(600);  // Starting x position of the new window
        slideIn.setToX(0);      // Ending x position of the new window
        slideIn.play();

        TranslateTransition slideIin = new TranslateTransition(Duration.seconds(0.7), trainAddStationPane);
        slideIin.setFromX(-600);  // Starting x position of the new window
        slideIin.setToX(0);      // Ending x position of the new window
        slideIin.play();


    }

    private void loadTrainIDCB() {
        try {
            ObservableList<String> obList = FXCollections.observableArrayList();
            List<String> ids = trainBO.loadtrainIds();

            for (String id : ids) {
                obList.add(id);
            }
            TrainIDComboBox.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }

    private void loadStationNameComboBox() {
        try {
            ObservableList<String> obList = FXCollections.observableArrayList();
            List<String> ids = trainBO.loadIds();

            for (String id : ids) {
                obList.add(id);
            }
            stationNameComboBox.setItems(obList);
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "SQL Error!").show();
        }
    }
    @FXML
    void TrainIDCBOnAction(ActionEvent event) {

    }


    @FXML
    void trainaddStationButtonOnAction(ActionEvent event) {
        String trainId = TrainIDComboBox.getValue();
        String StationId = stationNameComboBox.getValue();
        Time time = Time.valueOf(timeTextField.getText());



        StationDetails stationDetails = new StationDetails(trainId,StationId, time);

        try {
            boolean isSaved = trainBO.save(stationDetails);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item saved!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
        }


    }

    @FXML
    void StationNameComboBoxOnAction(ActionEvent event) {

    }



    @FXML
    void addTrainButtonOnAction(ActionEvent event) {
        String id = trainIDButton.getText();

        String name = nameTextField.getText();
        Time time = Time.valueOf(journeyToTextField.getText());
        String endStation = EndStationTextField.getText();

        Train train = new Train(id, name, time,endStation);

        try {
            boolean isSaved = trainBO.save(train);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item saved!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
        }

    }

    @FXML
    void deleteButtonOnAction(ActionEvent event) throws SQLException {
        String code = trainIDButton.getText();
        try {
            boolean isDeleted = trainBO.delete(code);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "deleted!").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Notification.notification(AlertTypes.ERROR,"ERROR !","Something happened !");

        }

    }

    @FXML
    void searchButtonOnAction(ActionEvent event) {
        try {
            TrainDTO train = trainBO.search(trainIDButton.getText());
            if (train != null) {
                trainIDButton.setText(train.getId());
                nameTextField.setText(train.getName());
                journeyToTextField.setText(String.valueOf(train.getTime()));
                EndStationTextField.setText((train.getEndStation()));


            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "something happened!").show();
        }

    }

    @FXML
    void updateButtonOnAction(ActionEvent event) {
        String id = trainIDButton.getText();
        String name = nameTextField.getText();
        Time time = Time.valueOf(journeyToTextField.getText());
        String endStation = EndStationTextField.getText();


         Train train=new Train(id,name,time,endStation);

        try {
            boolean isUpdated= trainBO.update(train);
            System.out.println(isUpdated);
            if(isUpdated) new Alert(Alert.AlertType.CONFIRMATION, "updated!").show();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        /*try (Connection con = DBConnection.getInstance().getConnection()) {
            String sql = "UPDATE Train SET TrainName = ?, Time = ? WHERE TrainID = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setTime(2, time);
            pstm.setString(3, id);
*/
           // boolean isUpdated = pstm.executeUpdate() > 0;

        }



    @FXML
    void wichComboBoxOnAction(ActionEvent event) {

    }



    @FXML
    void addStationOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/station_form.fxml"));
        Pane registerPane = fxmlLoader.load();

        try {
            PaneStation.getChildren().clear();
            PaneStation.getChildren().setAll(registerPane);
            System.gc();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
