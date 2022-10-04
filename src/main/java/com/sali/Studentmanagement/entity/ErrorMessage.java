package com.sali.Studentmanagement.entity;

import org.springframework.http.HttpStatus;

public class ErrorMessage {


    private HttpStatus status;
    private String message;
    public ErrorMessage() {
    }

    public ErrorMessage(HttpStatus status, String message) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
