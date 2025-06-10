package dev.emortal.minestom.holeymoley.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class EventManager {

    private final Map<String, Class<? extends Event>> eventMap = new HashMap<>();

    public EventManager() {}

    public void registerEvent(String eventId, Class<? extends Event> event) {
        eventMap.put(eventId, event);
    }

    public Event createRandomEvent() {
        var events = new ArrayList<>(eventMap.values());
        ThreadLocalRandom random = ThreadLocalRandom.current();
        var randomEventClass = events.get(random.nextInt(events.size()));
        try {
            return randomEventClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
