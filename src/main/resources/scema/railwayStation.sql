DROP DATABASE railwayStation;
CREATE DATABASE railwayStation;
USE railwayStation;
CREATE TABLE User(
    UserID INTEGER(6)PRIMARY KEY NOT NULL ,
    UserName VARCHAR(20) NOT NULL ,
    PassWord VARCHAR(10) NOT NULL,
    ContactNum VARCHAR(15) NOT NULL,
    Address VARCHAR (30) NOT NULL ,
    Email VARCHAR(30) NOT NULL

);
CREATE TABLE LogHistory(
    UserID INTEGER(6) NOT NULL,
    LogInDate DATE ,
    LogInTime TIME ,
    LogOutDate DATE ,
    LogOutTime TIME ,
    CONSTRAINT FOREIGN KEY(UserID) REFERENCES User(UserID)
        ON UPDATE CASCADE ON DELETE CASCADE

);
CREATE TABLE Employee(
    EmployeeID VARCHAR(6) NOT NULL,
    EmpName VARCHAR(15) NOT NULL ,
    EmpDob DATE NOT NULL ,
    EmpContact VARCHAR(12) NOT NULL ,
    EmpAddress VARCHAR (30) NOT NULL ,
    CONSTRAINT PRIMARY KEY (EmployeeID)
);
CREATE TABLE Salary(
    SalaryID VARCHAR(6)NOT NULL ,
    EmployeeID VARCHAR(6) NOT NULL,
    Date DATE NOT NULL ,
    Amount DECIMAL(20,2) NOT NULL ,
    CONSTRAINT PRIMARY KEY (SalaryID),
    CONSTRAINT FOREIGN KEY(EmployeeID) REFERENCES Employee(EmployeeID)
                   ON UPDATE CASCADE ON DELETE CASCADE

);

CREATE TABLE Station(
    StationID VARCHAR(6) NOT NULL ,
    StationName VARCHAR(20) NOT NULL,
    Distance DECIMAL(20,2) NOT NULL ,
    CONSTRAINT PRIMARY KEY (StationName)


);
CREATE TABLE Train(
    TrainID VARCHAR(6) NOT NULL,
    TrainName VARCHAR(12) NOT NULL,
    Time TIME NOT NULL,
    EndStation VARCHAR(20) NOT NULL ,
    CONSTRAINT PRIMARY KEY (TrainID)

);
CREATE TABLE StationDetails(
    TrainID VARCHAR(6) NOT NULL,
    StationName VARCHAR(20) NOT NULL,
    Time TIME NOT NULL ,
    CONSTRAINT PRIMARY KEY (TrainID,StationName),

    CONSTRAINT FOREIGN KEY (StationName) REFERENCES Station(StationName)
        ON UPDATE CASCADE ON DELETE CASCADE ,
    CONSTRAINT FOREIGN KEY (TrainID) REFERENCES Train(TrainID)
        ON UPDATE CASCADE ON DELETE CASCADE


);

CREATE TABLE Ticket(
    TicketID VARCHAR(6) NOT NULL,
    TrainID VARCHAR(6) NOT NULL ,
    StationName VARCHAR(20) NOT NULL ,
    ClassType VARCHAR(20) NOT NULL ,
    HowMany INTEGER (10) ,
    price DECIMAL (20,2) not null,
    CONSTRAINT PRIMARY KEY (TicketID),
    CONSTRAINT FOREIGN KEY (TrainID) REFERENCES Train(TrainID)
                   ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FOREIGN KEY (StationName) REFERENCES Station(StationName)
                   ON UPDATE CASCADE ON DELETE CASCADE

);
CREATE TABLE Booking(
    BookingID VARCHAR(6) NOT NULL,
    Date      VARCHAR(20)   NOT NULL,
    ToDate    DATE   NOT NULL,
    TrainID   VARCHAR(6) NOT NULL,
    StationName VARCHAR(20) NOT NULL ,
    SeatsID VARCHAR(6) NOT NULL ,
    price DECIMAL (20,2) NOT NULL ,
    CONSTRAINT PRIMARY KEY (BookingID),
    CONSTRAINT FOREIGN KEY (TrainID) REFERENCES Train (TrainID)
        ON UPDATE CASCADE ON DELETE CASCADE,
        CONSTRAINT FOREIGN KEY (StationName) REFERENCES Station (StationName)
                    ON UPDATE CASCADE ON DELETE CASCADE
);

        CREATE TABLE Payment(
        PaymentID VARCHAR(6) NOT NULL,
        TicketID VARCHAR(6),
        BookingID VARCHAR(6),
        Date VARCHAR(20) NOT NULL,
        price DECIMAL(20,2) NOT NULL,
        CONSTRAINT PRIMARY KEY (PaymentID),
        CONSTRAINT FOREIGN KEY (TicketID) REFERENCES Ticket(TicketID),
        CONSTRAINT FOREIGN KEY (BookingID) REFERENCES Booking(BookingID)

);
CREATE TABLE Passenger(
    PassengerID VARCHAR(6) NOT NULL ,
    PassengerName VARCHAR(20) NOT NULL ,
    BookingID VARCHAR(6) NOT NULL ,
    ContactNum VARCHAR(20) NOT NULL ,
    Email VARCHAR(30) NOT NULL ,
    Address VARCHAR(30) NOT NULL ,
    NIC VARCHAR(15) NOT NULL ,
    CONSTRAINT PRIMARY KEY (BookingID),
    CONSTRAINT FOREIGN KEY (BookingID) REFERENCES Booking(BookingID)
                      ON UPDATE CASCADE ON DELETE CASCADE

);


SELECT Payment.PaymentID,Booking.StationName,Payment.price
FROM Payment
INNER JOIN Booking ON Booking.BookingID = Payment.BookingID;



