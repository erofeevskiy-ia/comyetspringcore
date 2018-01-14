package com.yet.spring.core;

import com.yet.spring.core.beans.Client;
import com.yet.spring.core.loggers.Event;
import com.yet.spring.core.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private EventLogger eventLogger;


    App() {
        System.out.println("sadasdasdasdasdasdasdasddas");
    }

    App(Client client, EventLogger eventLogger) {
        this();
        this.client = client;
        this.eventLogger = eventLogger;
    }

    private void logEvent(Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {
        /*App app = new App(new Client("1","Blacke Bill"), new ConsoleEventLogger());
        app.client = new Client("1","Tom Basel");
        app.logEvent("some event for user 1");*/
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) applicationContext.getBean("app");
        Event event = (Event) applicationContext.getBean("event");
        app.logEvent(event, "log event for 1");
        event = (Event) applicationContext.getBean("event");
        app.logEvent(event, "log event for 2");

        applicationContext.close();

    }
}
