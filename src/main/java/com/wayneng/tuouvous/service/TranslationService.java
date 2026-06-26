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
    
            This is an adaptive translation task, not a literal translation task.
            
            Translate the sentence into the French that a native speaker would naturally use at the requested register.
            
            Do not translate word for word. Instead, adapt the wording to sound authentic and idiomatic.
            
            You may:
            - expand or condense the sentence where appropriate
            - use idioms, metaphors, or culturally natural expressions
            - replace literal wording with more natural French
            - use authentic slang when the STREET register is requested
            
            Always preserve the speaker's original intent, even if the wording changes substantially.
    
            English:
            %s
    
            Register:
            %s
    
            Return only the French translation.
            """
                .formatted(text, register);
    }
}
