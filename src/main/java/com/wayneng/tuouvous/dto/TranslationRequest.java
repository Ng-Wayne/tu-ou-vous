package com.wayneng.tuouvous.dto;

import com.wayneng.tuouvous.model.Register;

public record TranslationRequest(
        String text,
        Register register
) {
}