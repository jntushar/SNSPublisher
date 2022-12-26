package com.creditsaisonindia.SNSPublisher.model;

public class Event {

    private int id;
    private String eventType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventType='" + eventType + '\'' +
                '}';
    }
}
