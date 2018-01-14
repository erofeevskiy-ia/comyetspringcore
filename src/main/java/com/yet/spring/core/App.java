package com.yet.spring.core;

import com.yet.spring.core.beans.Client;
import com.yet.spring.core.enums.EventType;
import com.yet.spring.core.loggers.Event;
import com.yet.spring.core.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    private Client client;
    private EventLogger defaultEventLogger;
    private Map<EventType, EventLogger> loggers;


    App() {
        System.out.println("sadasdasdasdasdasdasdasddas");
    }

    App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this();
        this.client = client;
        this.defaultEventLogger = eventLogger;
        this.loggers = loggers;
    }

    private void logEvent(Event event, String msg, EventType eventType) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        EventLogger logger = loggers.get(eventType);
        if (logger == null)
            logger = defaultEventLogger;
        logger.logEvent(event);
    }

    public static void main(String[] args) {
        /*App app = new App(new Client("1","Blacke Bill"), new ConsoleEventLogger());
        app.client = new Client("1","Tom Basel");
        app.logEvent("some event for user 1");*/
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) applicationContext.getBean("app");
        Event event = (Event) applicationContext.getBean("event");
        app.logEvent(event, "log event for 1", EventType.INFO);
        event = (Event) applicationContext.getBean("event");
        app.logEvent(event, "log event for 2", EventType.ERROR);
        event = (Event) applicationContext.getBean("event");
        app.logEvent(event, "log event for 3", EventType.ERROR);

        applicationContext.close();

    }
}
