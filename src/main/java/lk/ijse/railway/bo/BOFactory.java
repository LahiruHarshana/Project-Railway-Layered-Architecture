package lk.ijse.railway.bo;

import lk.ijse.railway.bo.custom.impl.*;

public class BOFactory {
        private static BOFactory boFactory;
        private BOFactory(){
        }
        public static BOFactory getBoFactory(){
            return (boFactory==null)? boFactory=new BOFactory() : boFactory;
        }

        public enum BOTypes{
            BOOKING,CHANGEPSWD,EMPLOYEE,HOME,LOGIN,LOGINHISTORY,PASSENGER,SALARY,SEATS,SETTINGS,SIGNUP,STATION,TICKET,TICKETING,TRAIN,TRAINSHEDULE,VIEWTRAIN
        }

        //Object creation logic for BO objects
        public <T extends SuperBO>T getBO(BOTypes types){
            switch (types){
                case BOOKING:
                    return (T) new BookingBOImpl();
                case CHANGEPSWD:
                    return (T) new ChangePasswordBOImpl();
                case EMPLOYEE:
                    return (T) new EmployeeBOImpl();
                case HOME:
                    return (T) new HomeBOImpl();
                case LOGIN:
                    return (T) new LoginBOImpl();
                case LOGINHISTORY:
                    return (T) new LoginHistoryBOImpl();
                case PASSENGER:
                    return (T) new PassengerBOImpl();
                case SALARY:
                    return (T) new SalaryBOImpl();
                case SEATS:
                    return (T) new SeatsBOImpl();
                case SETTINGS:
                    return (T) new SettingBOImpl();
                case SIGNUP:
                    return (T) new SignUpPasswordBOImpl();
                case STATION:
                    return (T) new StationBOImpl();
                case TICKET:
                    return (T) new TicketBOImpl();
                case TICKETING:
                    return (T) new TicketingBOImpl();
                case TRAIN:
                    return (T) new TrainBOImpl();
                case TRAINSHEDULE:
                    return (T) new TrainSheduleBOImpl();
                case VIEWTRAIN:
                default:
                    return null;
            }
        }



}
