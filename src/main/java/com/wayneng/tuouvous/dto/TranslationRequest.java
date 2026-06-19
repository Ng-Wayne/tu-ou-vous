package com.wayneng.tuouvous.dto;

public record TranslationRequest(
        String text,
        int level
) {
}