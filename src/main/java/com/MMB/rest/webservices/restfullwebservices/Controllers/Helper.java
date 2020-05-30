package com.MMB.rest.webservices.restfullwebservices.Controllers;

public class Helper {
    private final String message;

    public Helper(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}