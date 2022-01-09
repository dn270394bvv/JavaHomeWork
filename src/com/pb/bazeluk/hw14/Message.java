package com.pb.bazeluk.hw14;

import java.time.LocalDateTime;

public class Message {
    private String user;
    private String message;
    private final LocalDateTime time = LocalDateTime.now();

    public Message(String user,String massage){
        this.message = massage;
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
