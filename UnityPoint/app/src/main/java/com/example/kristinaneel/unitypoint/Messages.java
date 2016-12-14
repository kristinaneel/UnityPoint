package com.example.kristinaneel.unitypoint;

/**
 * Created by cutle on 12/13/2016.
 */

public class Messages {
    private String sender;
    private String text;

    public Messages(String sender, String text) {
        this.sender = sender;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSender() {

        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
