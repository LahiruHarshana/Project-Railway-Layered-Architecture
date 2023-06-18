package lk.ijse.railway.controller;

import lk.ijse.railway.controller.util.Notification;
import lk.ijse.railway.controller.util.AlertTypes;

import javax.mail.*;
import javax.mail.internet.*;
import java.sql.Date;
import java.util.Properties;





public class sendMail {

    public static void send(String bookingId, String date, Date toDate, String trainId, String stationName, String seatsId, Double price, String email, String name){
        //final String username = "lharshana2002@gmail.com";
        //final String password = "yimfkbcwlqwnaimb";


        final String username = "railwaystation.galle@gmail.com";

        final String password = "u x x w p q v t m d t w g t h l";



        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");


        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });





        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email,false)
            );
            message.setSubject("Hi "+name+" your seat is booked !");
//            message.setSubject("Meeting !");
            message.setText("Your book ID : "+bookingId+"      Date : "+date+" \nto Date : "+toDate+"        Train ID : "+trainId+" \nStation Name : "+stationName+"        Seats ID : "+seatsId+" \nPrice Rs :"+price+"");

            Transport.send(message);

            Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION","The email was successfully sent!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}
