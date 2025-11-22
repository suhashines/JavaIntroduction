package Networking.realtimeChatApp.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private final String sender;
    private final String text;
    private final LocalDateTime time;

    public Message(String sender, String text) {
        this.sender = sender;
        this.text = text;
        this.time = LocalDateTime.now();
    }

    public String getSender() { return sender; }
    public String getText() { return text; }
    public LocalDateTime getTime() { return time; }

    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm:ss");
        return "[" + time.format(f) + "] " + sender + ": " + text;
    }
}
