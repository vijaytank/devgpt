package com.app.devgpt.security;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class OpenAIKeyValidator {

    public boolean validateOpenAiApiKey(String apiKey) {
        String url = "https://api.openai.com/v1/chat/completions";
        String model = "gpt-3.5-turbo";

        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            connection.setRequestProperty("Content-Type", "application/json");

            // The request body
            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + "hi" + "\"}]}";
            connection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();

            // Response from ChatGPT
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            StringBuilder response = new StringBuilder();

            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            // calls the method to extract the message.
            String result = extractMessageFromJSONResponse(response.toString());

            if (result.equalsIgnoreCase("Invalid API key provided") || result.equalsIgnoreCase("false")) {
                return false;
            } else if(result.contains("Hello")){
                return true;
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }

    private String extractMessageFromJSONResponse(String response) throws IOException {
        int start = response.indexOf("content") + 11;

        int end = response.indexOf("\"", start);

        String message = response.substring(start, end);

        if (message.equalsIgnoreCase("Invalid API key provided")) {
            return "Invalid API key provided";
        }
        else{
            return "true";
        }
    }
}
