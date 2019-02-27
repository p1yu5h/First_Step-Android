package com.firststep.www;

import java.util.Date;

public class Notification {
    String topic,description,file_link;

    public Notification(String topic, String description, String file_link, Date event_date) {
        this.topic = topic;
        this.description = description;
        this.file_link = file_link;
        this.event_date = event_date;
    }

    Date event_date;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFile_link() {
        return file_link;
    }

    public void setFile_link(String file_link) {
        this.file_link = file_link;
    }

    public Date getEvent_date() {
        return event_date;
    }

    public void setEvent_date(Date event_date) {
        this.event_date = event_date;
    }
}
