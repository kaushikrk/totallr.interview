package com.totallr.demo.model;

public class Response {
    String message;
    int status;

    public Response() {}

    public Response(String _message, int _status) {
        this.message = _message;
        this.status = _status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String _message) {
        this.message = _message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int _status) {
        this.status = _status;
    }
}
