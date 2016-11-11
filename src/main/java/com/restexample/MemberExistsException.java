package com.restexample;

/**
 * Created by hamz on 8/31/15.
 */
public class MemberExistsException extends RuntimeException {
    public MemberExistsException() {
    }

    public MemberExistsException(String message) {
        super(message);
    }

    public MemberExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
