package com.app.devgpt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class OtpService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String emailSender;

    public void sendOtp(String email) {
        String otp = generateOtp();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("OTP Verification");
        message.setText("Your OTP is: " + otp);

        javaMailSender.send(message);

        // Implement logic to store OTP and email in the database with JPA
        // or any other persistence mechanism
        // (e.g., Redis, DynamoDB, etc.)
        // to be used later for OTP verification
        // (e.g., in the UserDetailsService.java file)
        System.out.println("OTP sent to " + email);
        System.out.println("OTP: " + otp);

        // Implement logic to send OTP to the user's email address
        // (e.g., using JavaMailSender)
        // to be used later for OTP verification
        // (e.g., in the UserDetailsService.java file)
        // System.out.println("OTP sent to " + email);
        // System.out.println("OTP: " + otp);

        // Implement logic to send OTP to the user's email address
        // (e.g., using JavaMailSender)
        // to be used later for OTP verification
        // (e.g., in the UserDetailsService.java file)
        System.out.println("OTP sent to " + email);
        System.out.println("OTP: " + otp);

        // Implement logic to send OTP to the user's email address
        // (e.g., using JavaMailSender)

    }

    private String generateOtp() {
        // Implement logic to generate a random OTP (e.g., using Random class)
        // to be used later for OTP verification
        // (e.g., in the UserDetailsService.java file)
        System.out.println("OTP generated");
        System.out.println("OTP: " + "123456"); // Replace with actual OTP
        return "123456"; // Replace with actual OTP
    }
}
