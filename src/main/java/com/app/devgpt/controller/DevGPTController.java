package com.app.devgpt.controller;
import com.app.devgpt.model.DevGPTRequest;
import com.app.devgpt.model.DevGPTResponse;
import com.app.devgpt.security.OpenAIKeyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/devgpt")
public class DevGPTController {

    @Autowired
    private OpenAIKeyValidator openAIKeyValidator;

    @PostMapping
    public DevGPTResponse generateResponse(@RequestBody DevGPTRequest request) {
        openAIKeyValidator.validateOpenAiApiKey(request.getOpenaiApiKey());
        DevGPTResponse response = new DevGPTResponse();
        response.setResponse("Hello, you said: " + request.getInput());
        return response;
    }
}
