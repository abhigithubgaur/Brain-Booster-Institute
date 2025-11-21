package com.example.coaching.service;


import com.example.coaching.model.AddmissionForm;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    // Change to your receiving email
    private final String ADMIN_EMAIL = "aabhikkumar1602@gmail.com";

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendAdmissionNotification(AddmissionForm form) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(ADMIN_EMAIL);
        message.setSubject("📩 New Admission Form Submitted");

        message.setText(
                "NEW ADMISSION FORM\n\n" +
                        "Name: " + form.getName() + "\n" +
                        "Phone: " + form.getPhone() + "\n" +
                        "Email: " + form.getEmail() + "\n" +
                        "Class: " + form.getStudentClass() + "\n\n" +
                        "Message:\n" + form.getMessage()
        );

        mailSender.send(message);
    }
}

