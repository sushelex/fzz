package framework;

import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;    
class Mailer{  
    public static void send(String from,String password,String sub,String msg){  
          //Get properties object    
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
//           message.addRecipient(Message.RecipientType.TO,new InternetAddress("s.karunanithi@sasken.com"));    
//           message.addRecipient(Message.RecipientType.TO,new InternetAddress("divyalakshmi.govindan@sasken.com"));  
//           message.addRecipient(Message.RecipientType.TO,new InternetAddress("venkata.yadavalli@sasken.com"));  
           message.addRecipient(Message.RecipientType.TO,new InternetAddress("vikas.desai@sasken.com"));  
           message.addRecipient(Message.RecipientType.TO,new InternetAddress("shrinath.inamdar@sasken.com"));  
           

           message.setSubject(sub);     
           message.setText(msg);    
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {System.out.println(e.getMessage());}    
             
    }  
}  
public class SendMailSSL{    
 public static void main(String[] args) {    
     //from,password,to,subject,message  
	 Mailer.send("mkaru1437@gmail.com","Karuna@88","Autoamtion Email from Sasken Tech","Able to recive the mail..");  
     //change from, password and to  
 }    
}    