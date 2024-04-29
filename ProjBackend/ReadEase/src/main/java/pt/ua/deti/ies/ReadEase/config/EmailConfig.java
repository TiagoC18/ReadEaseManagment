package pt.ua.deti.ies.ReadEase.config;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig
{
	@Bean
	public JavaMailSender getJavaMailSender()
	{
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);

	    mailSender.setUsername("readeasemagement2023@gmail.com");
	    mailSender.setPassword("Olaola123");

	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");

	    return mailSender;
	}

	@Bean
	public SimpleMailMessage emailTemplate()
	{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("somebody@gmail.com");
		message.setFrom("readeasemagement2023@gmail.com");
	    message.setText("FATAL - Application crash. Save your job !!");
	    return message;
	}
}
