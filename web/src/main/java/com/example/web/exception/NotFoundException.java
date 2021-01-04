package com.example.web.exception;

import com.example.web.ApiStatus;

/**
 * @author ock
 */
public class NotFoundException extends ApiException {
    /**
     *
     */
    public NotFoundException() {
        super(ApiStatus.NOT_FOUND, "");
    }

    /**
     * @param message
     */
    public NotFoundException(String message) {
        super(ApiStatus.NOT_FOUND, message);
    }
}
