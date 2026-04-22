package com.ipicicd.Dto;

import java.time.LocalDateTime;

public record PostResponse(
        Long id,
        String title,
        String content,
        Long userId,
        String username,
        LocalDateTime timestamp
) {
}

