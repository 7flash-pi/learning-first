package com.learning.learning_first.entities;

public class ApiResponse<T> {
    private int statusCode;

    private String statusMessage;
    private T data;
    
    public ApiResponse ( int statusCode, String statusMessage,T data){
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.data = data;
    }

    //Getter and setters

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    
}
