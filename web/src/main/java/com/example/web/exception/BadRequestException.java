package com.example.web.exception;

import com.example.web.ApiStatus;

/**
 * @author ock
 */
public class BadRequestException extends ApiException {
    /**
     *
     */
    public BadRequestException() {
        super(ApiStatus.BAD_REQUEST, "");
    }

    /**
     * @param message
     */
    public BadRequestException(String message) {
        super(ApiStatus.BAD_REQUEST, message);
    }
}
