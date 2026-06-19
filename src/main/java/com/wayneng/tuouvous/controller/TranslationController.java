package com.wayneng.tuouvous.controller;

import com.wayneng.tuouvous.dto.TranslationRequest;
import com.wayneng.tuouvous.dto.TranslationResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/translate")
public class TranslationController {

    @PostMapping
    public TranslationResponse translate(
            @RequestBody TranslationRequest request) {

        return new TranslationResponse("Bonjour");
    }
}