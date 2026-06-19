package com.wayneng.tuouvous.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TranslationService {

    private final OllamaService ollamaService;

    public String translate(String text, int level) {

        String prompt = buildPrompt(text, level);

        return ollamaService.translate(prompt);
    }

    private String buildPrompt(String text, int level) {

        return """
            You are a professional English-to-French translator.

            Translate the sentence into French.

            Formality levels:

            Level 1:
            Very informal French used with close friends.

            Level 2:
            Informal everyday conversation.

            Level 3:
            Neutral standard French.

            Level 4:
            Formal professional French.

            Level 5:
            Very formal French suitable for official correspondence.

            English:
            %s

            Formality Level:
            %d

            Return ONLY the French translation.

            Do NOT:
            - explain
            - justify
            - add labels
            - mention the formality level
            - add comments
            """
                .formatted(text, level);
    }
}
