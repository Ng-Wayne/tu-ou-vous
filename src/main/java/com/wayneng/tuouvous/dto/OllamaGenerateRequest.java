package com.wayneng.tuouvous.dto;

public record OllamaGenerateRequest(
        String model,
        String prompt,
        boolean stream
) {
}