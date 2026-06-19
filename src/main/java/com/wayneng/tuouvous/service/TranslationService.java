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
                Translate the following English sentence into French.

                Formality Levels:
                1 = Very informal
                2 = Informal
                3 = Neutral
                4 = Formal
                5 = Very formal

                English:
                %s

                Formality Level:
                %d

                Output only the translation.
                """
                .formatted(text, level);
    }
}
