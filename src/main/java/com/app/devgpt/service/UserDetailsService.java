package com.app.devgpt.service;

import com.app.devgpt.config.OpenAIConfig;
import com.app.devgpt.model.ProjectDetails;
import com.app.devgpt.model.UserDetails;
import com.app.devgpt.repository.ProjectDetailsRepository;
import com.app.devgpt.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {

    @Autowired
    private UserDetailsRepository userRepository;

    @Autowired
    private OtpService otpService;

    @Autowired
    private OpenAIConfig openAIConfig;
    @Autowired
    private ProjectDetailsRepository projectDetailsRepository;

    public UserDetails registerUser(UserDetails userDetails) {
        // Implement registration logic
        UserDetails savedUser = userRepository.save(userDetails);

        // Save project details for the user
        ProjectDetails projectDetails = new ProjectDetails();
        projectDetails.setProjectOwner(savedUser.getUsername());
        projectDetails.setProjectOwnerEmail(savedUser.getEmail());
        projectDetails.setProjectOwnerPhone(savedUser.getMobile());
        projectDetails.setUser(savedUser);
        projectDetailsRepository.save(projectDetails);

        // Send OTP to the registered email
        otpService.sendOtp(savedUser.getEmail());

        validateOpenAiApiKey(openAIConfig.getOpenAIApiKey());

        return savedUser;
    }

    private void validateOpenAiApiKey(String apiKey) {
        // Implement logic to validate the OpenAI API key
        // If validation fails, handle accordingly (throw an exception, log)


    }
}
