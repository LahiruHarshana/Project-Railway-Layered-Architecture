package lk.ijse.railway.bo.custom.impl;

import lk.ijse.railway.bo.custom.TrainSheduleBO;
import lk.ijse.railway.dao.DAOFactory;
import lk.ijse.railway.dao.custom.impl.TrainDAOImpl;
import lk.ijse.railway.entity.Train;
import lk.ijse.railway.model.TrainDTO;

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
