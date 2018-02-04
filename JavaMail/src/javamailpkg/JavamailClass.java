package javamailpkg;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


public class JavamailClass {

	public static void main(String[] args) {
		
		Gmail.send("moremegha15@gmail.com","dineromegha","prashantmasekar101@gmail.com ","send Email by java","Hello");
		
	}
}
	
	class Gmail{
		public static void send(String from,String password,String to,String sub,String msg)
		{
			//get properties object
		Properties props =new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mai.smtp.auth","true");
		props.put("mail.smtp.port", "465");
		
		
		//get Session
		Session session= Session.getDefaultInstance(props,new javax.mail.Authenticator() {
			
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(from,password);
				}
					});
		//compose message
		try {
			MimeMessage message=new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			message.setSubject(sub);
			message.setText(msg);
		//Send 	
			Transport.send(message);
			System.out.println("message send suceesfully");

		}
		catch(MessagingException e) {throw new RuntimeException(e);}
			
		
		
	}
}

