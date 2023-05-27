package lk.ijse.railway.util;
import javafx.scene.control.Alert;
import javazoom.jl.player.Player;
import lk.ijse.railway.dao.custom.TrainDAO;
import lk.ijse.railway.dto.Train;
import lk.ijse.railway.dao.custom.impl.TrainDAOImpl;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class TimeChecker {



    int value;
    public static void tread() throws InterruptedException {

//        Thread thread = new Thread(() -> {
//
//            while (true) {
//                try {
//                    LocalTime currentTime = LocalTime.now();
//                    LocalTime fiveMinutesAgo = currentTime.plusMinutes(5);
//                    Time time = Time.valueOf(formatTime(fiveMinutesAgo));
//                    try {
//                        TrainDAO trainDAO = new TrainDAOImpl();
//                        Train train = trainDAO.searchTime(time);
//                        if (train != null) {
//                            String name = train.getName();
//                            try {
//                                File audioFile = new File("src/main/resources/Sounds/ttsMP3.com_VoiceText_2023-4-30_1_39_54.mp3");
//                                FileInputStream audioStream = new FileInputStream(audioFile);
//                                Player player = new Player(audioStream);
//                                player.play();
//                            } catch (Exception ex) {
//                                ex.printStackTrace();
//                            }
//                        }
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                        new Alert(Alert.AlertType.ERROR, "something happened!").show();
//                    }
//                    Thread.sleep(1000);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();
    }
    private static String formatTime(LocalTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return formatter.format(time);
    }

}
