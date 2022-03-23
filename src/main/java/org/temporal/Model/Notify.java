package org.temporal.Model;

public class Notify {

    private String sender;
    private String reciever;
    private Object message;
    private String channels;
    private Boolean broadcast;

    public Notify(String sender, String reciever, Object message, String channels) {
        this.sender = sender;
        this.reciever = reciever;
        this.message = message;
        this.channels = channels;
        this.broadcast = true;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public String getChannels() {
        return channels;
    }

    public void setChannels(String channels) {
        this.channels = channels;
    }

    public Boolean getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(Boolean broadcast) {
        this.broadcast = broadcast;
    }
}
