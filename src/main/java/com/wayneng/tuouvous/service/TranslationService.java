package com.wayneng.tuouvous.service;

import com.wayneng.tuouvous.model.Register;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TranslationService {

    private final OllamaService ollamaService;

    public String translate(String text, Register register) {

        String prompt = buildPrompt(text, register);

        return ollamaService.translate(prompt);
    }

    private String buildPrompt(String text, Register register) {

        return """
            You are an English-to-French translator.
    
            Translate the English sentence into French.
        
            Use the requested French register:
    
            STREET = very informal French between close friends.
            CONVERSATIONAL = informal everyday French.
            STANDARD = neutral French.
            FORMAL = professional and polite French.
            ADMINISTRATIVE = highly formal French for official correspondence.
    
            English:
            %s
    
            Register:
            %s
    
            Return only the French translation.
            """
                .formatted(text, register);
    }
}
