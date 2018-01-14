package com.yet.spring.core.loggers;

import java.util.LinkedList;
import java.util.List;

public class CacheFileLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;

    CacheFileLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
        cache = new LinkedList<>();
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize) {
            writeEventFromCache();
            cache.clear();
        }
    }

    public void destroy() {
        if (!cache.isEmpty())
            writeEventFromCache();
    }

    private void writeEventFromCache() {
        for (Event e : cache)
            super.logEvent(e);
    }
}
