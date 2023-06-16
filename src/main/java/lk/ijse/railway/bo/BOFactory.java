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
        public SuperBO getBO(BOTypes types){
            switch (types){
                case BOOKING:
                    return new BookingBOImpl();
                case CHANGEPSWD:
                    return new ChangePasswordBOImpl();
                case EMPLOYEE:
                    return new EmployeeBOImpl();
                case HOME:
                    return new LoginBOImpl();
                case LOGIN:
                    return new LoginHistoryBOImpl();
                case PASSENGER:
                    return new PassengerBOImpl();
                case SALARY:
                    return new SalaryBOImpl();
                case SEATS:
                    return new SeatsBOImpl();
                case SETTINGS:
                    return new SettingBOImpl();
                case SIGNUP:
                    return new SignUpPasswordBOImpl();
                case STATION:
                    return new StationBOImpl();
                case TICKET:
                    return new TicketBOImpl();
                case TICKETING:
                    return new TicketingBOImpl();
                case TRAIN:
                    return new TrainBOImpl();
                case TRAINSHEDULE:
                    return new TrainSheduleBOImpl();
                case VIEWTRAIN:
                default:
                    return null;
            }
        }



}
