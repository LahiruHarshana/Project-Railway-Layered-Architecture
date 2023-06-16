package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.bo.custom.TrainSheduleBO;
import lk.ijse.railway.dao.DAOFactory;
import lk.ijse.railway.dao.custom.impl.TrainDAOImpl;
import lk.ijse.railway.dto.LoginHistory;
import lk.ijse.railway.dto.Train;
import lk.ijse.railway.model.LoginHistoryDTO;
import lk.ijse.railway.model.TrainDTO;
import lk.ijse.railway.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainSheduleBOImpl implements TrainSheduleBO {
    TrainDAOImpl trainDAO = (TrainDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TRAIN);
    @Override
    public List<TrainDTO> getAll() throws SQLException {
            List<Train> allEntityData = trainDAO.getAll();
            ArrayList<TrainDTO> allDTOData= new ArrayList<>();
            for (Train i : allEntityData) {
                allDTOData.add(new TrainDTO(i.getId(),i.getName(),i.getTime(),i.getEndStation()));
            }
            return allDTOData;
    }
}
