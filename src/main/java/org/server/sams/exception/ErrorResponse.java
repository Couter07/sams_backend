package org.server.sams.exception;

import org.springframework.http.HttpStatus;

import java.util.Map;

public record ErrorResponse(
        HttpStatus status,
        String message,
        Map<String, String> errors // field-name: error message
) {}
