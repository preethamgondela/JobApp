package com.initialpages.signup.and.login.util;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
//import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendVerificationEmail(String toEmail, String subject, String content) throws jakarta.mail.MessagingException {
        // Create a MimeMessage object
        jakarta.mail.internet.MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        // Set the From address, To address, subject, and content
        helper.setFrom("your_email@gmail.com");
        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(content);

        // Send the email
        javaMailSender.send(message);
        System.out.println("Email sent successfully!");
    }
}
