package com.wayneng.tuouvous.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TranslationService {

    private final OllamaService ollamaService;

    public String translate(String text, String register) {

        String prompt = buildPrompt(text, register);

        return ollamaService.translate(prompt);
    }

    private String buildPrompt(String text, String register) {

        return """
            You are a professional English-to-French translator.
    
            Translate the English sentence into French using the requested French register.
    
            Available Registers:
    
            STREET
            - Very informal French.
            - Used between close friends.
            - Slang and colloquial expressions are acceptable.
            - Use "tu" forms.
    
            CONVERSATIONAL
            - Natural everyday spoken French.
            - Friendly and informal.
            - Suitable for friends, classmates, and familiar colleagues.
            - Prefer "tu" forms.
    
            STANDARD
            - Neutral modern French.
            - Suitable for most situations.
            - Avoid slang and avoid excessive formality.
            - Use the most natural wording.
    
            FORMAL
            - Professional and polite French.
            - Suitable for workplace communication and customer interactions.
            - Prefer "vous" forms.
            - Use polite phrasing where appropriate.
    
            ADMINISTRATIVE
            - Very formal French.
            - Suitable for official correspondence, government communication,
              legal, diplomatic, or highly deferential contexts.
            - Use "vous" forms.
            - Use elevated and highly respectful phrasing where appropriate.
    
            Examples:
    
            English:
            Could you send me the report?
    
            STREET:
            Tu peux m'envoyer le rapport ?
    
            CONVERSATIONAL:
            Tu pourrais m'envoyer le rapport ?
    
            STANDARD:
            Peux-tu m'envoyer le rapport ?
    
            FORMAL:
            Pourriez-vous m'envoyer le rapport ?
    
            ADMINISTRATIVE:
            Je vous serais reconnaissant de bien vouloir me transmettre le rapport.
    
            English:
            Hello
    
            STREET:
            Salut !
    
            CONVERSATIONAL:
            Salut, ça va ?
    
            STANDARD:
            Bonjour.
    
            FORMAL:
            Bonjour, comment allez-vous ?
    
            ADMINISTRATIVE:
            Je vous prie d'agréer mes salutations distinguées.
    
            Translate the following sentence.
    
            English:
            %s
    
            Register:
            %s
    
            Return ONLY the French translation.
    
            Do NOT:
            - explain the translation
            - justify word choices
            - add labels
            - add comments
            - add quotation marks
            - mention the register
            """
                .formatted(text, register);
    }
}
