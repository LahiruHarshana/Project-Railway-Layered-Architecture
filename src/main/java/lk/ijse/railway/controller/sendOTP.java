package lk.ijse.railway.controller;

import lk.ijse.railway.controller.util.Notification;
import lk.ijse.railway.controller.util.AlertTypes;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.util.Properties;
public class sendOTP {

    public static OTPFormController otpFormController = new OTPFormController();
    public static void sendOtp(String name,String email){

        Random rand = new Random();

        int randNum = rand.nextInt(100001);

        otpFormController.randNum(randNum);


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
            message.setSubject("Hi "+name+" your OTP ");
//            message.setSubject("Meeting !");
            message.setText("OTP : "+randNum+"");

            Transport.send(message);

            Notification.notification(AlertTypes.CONFORMATION,"CONFORMATION !","Email send Successfull !");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
