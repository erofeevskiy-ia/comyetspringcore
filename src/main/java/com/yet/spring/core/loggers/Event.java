package com.yet.spring.core.loggers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;


public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat df;

    public Event() {
    }

    public Event(Date date, DateFormat df) {
        id = new Random().nextInt(1000000);
        this.date = date;
        this.df = df;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}' + '\n';
    }

}
