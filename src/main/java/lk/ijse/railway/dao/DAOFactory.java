package lk.ijse.railway.dao;

import lk.ijse.railway.dao.custom.impl.*;

public class DAOFactory {

        private static DAOFactory daoFactory;

        private DAOFactory() {
        }

        public static DAOFactory getDaoFactory() {
            return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
        }

        public enum DAOTypes {
            BOOKING,EMPLOYEE,LOGINHISTORY,PASSENGER,PAYMENT,SALARY,STATION,SATATIONDETAILS,TICKET,TRAIN,USER
        }

        public SuperDAO getDAO(DAOTypes types) {
            switch (types) {
                case BOOKING:
                    return new BookingDAOImpl();
                case EMPLOYEE:
                    return new EmployeeDAOImpl();
                case LOGINHISTORY:
                    return new LoginHistoryDAOImpl();
                case PASSENGER:
                    return new PassengerDAOImpl();
                case PAYMENT:
                    return new PaymentDAOImpl();
                case SALARY:
                    return new SalaryDAOImpl();
                case STATION:
                    return new StationDAOImpl();
                case SATATIONDETAILS:
                    return new StationDetailsDAOImpl();
                case TICKET:
                    return new TicketDAOImpl();
                case TRAIN:
                    return new TrainDAOImpl();
                case USER:
                    return new UserDAOImpl();
                default:
                    return null;
            }

        }

}
