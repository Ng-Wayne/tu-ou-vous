package com.wayneng.tuouvous.controller;

import com.wayneng.tuouvous.dto.TranslationRequest;
import com.wayneng.tuouvous.dto.TranslationResponse;
import com.wayneng.tuouvous.service.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/translate")
@RequiredArgsConstructor
public class TranslationController {

    private final TranslationService translationService;

    @PostMapping
    public TranslationResponse translate(
            @RequestBody TranslationRequest request) {

        return new TranslationResponse(
                translationService.translate(
                        request.text(),
                        request.level()
                )
        );
    }
}