package com.wayneng.tuouvous.service;

import com.wayneng.tuouvous.dto.OllamaGenerateRequest;
import com.wayneng.tuouvous.dto.OllamaGenerateResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class OllamaService {

    private final RestClient restClient = RestClient.create();

    public String translate(String prompt) {

        OllamaGenerateRequest request =
                new OllamaGenerateRequest(
                        "mistral:7b",
                        prompt,
                        false
                );

        OllamaGenerateResponse response =
                restClient.post()
                        .uri("http://localhost:11434/api/generate")
                        .body(request)
                        .retrieve()
                        .body(OllamaGenerateResponse.class);

        if (response == null) {
            throw new RuntimeException("No response from Ollama");
        }

        return response.response();
    }
}