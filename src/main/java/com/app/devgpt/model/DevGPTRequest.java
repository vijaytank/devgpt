package com.app.devgpt.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DevGPTRequest {
    private Long id;
    private String input;
    private String openaiApiKey;
    private String projectName;
    private String user;
}
