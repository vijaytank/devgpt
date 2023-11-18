package com.app.devgpt.security;

import org.springframework.stereotype.Component;

@Component
public class ProjectDetailsValidator {

    public boolean validateProjectDetails(String projectName, String user) {
        // Implement logic to validate project details
        // This method can only be called by users with the 'USER' role
        return true; // Replace with actual implementation
    }
}
