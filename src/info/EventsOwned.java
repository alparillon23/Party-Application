package info;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class EventsOwned implements Iterable<Event>{

    private ArrayList<Event> allEvents;
    private HashMap<Integer,Event> events;
    File eventRecords;
    PrintWriter out_eventRec;

    public EventsOwned(int user_id)
    {
        EventsBuilder eb = new EventsBuilder();
        allEvents = eb.getAllEvents();
        events = new HashMap<>();
        for(Event e: allEvents)
        {
            if(e.getCreatorId()==user_id)
                events.put(e.getId(),e);
        }
    }

    public void addEvent(int user_id,Event event)
    {
        EventsJoined ej = new EventsJoined(user_id);
        Event newEvent = new Event(getNewID(),user_id,event.getName(),event.getLocation(),event.getDate(),event.getTime());
        allEvents.add(newEvent);
        events.put(newEvent.getId(),newEvent);
        ej.newEvent(user_id, newEvent);
        ej.rewriteGuests();
    }

    public void removeEvent(int user_id,Event event)
    {
        EventsJoined ej = new EventsJoined(user_id);
        ArrayList<Event> ed = new ArrayList<>();
        events.remove(event.getId());
        for(Event e:allEvents)
        {
         if(e.getId()!=event.getId())
             ed.add(e);
        }
        allEvents=ed;
        ej.removedEvent(user_id,event);
        ej.rewriteGuests();
    }

    public void editEvent(int user_id,Event event)
    {
        EventsJoined ej = new EventsJoined(user_id);
        ArrayList<Event> ed = new ArrayList<>();
        events.remove(event.getId());
        for(Event e:allEvents)
        {
            if(e.getId()!=event.getId())
                ed.add(e);
        }
        allEvents=ed;
        allEvents.add(event);
        events.put(event.getId(),event);
    }

    public void refresh()
    {
        try {
            eventRecords = new File("src/info/eventFile/EventsRecords.txt");
            out_eventRec = new PrintWriter(new FileOutputStream(eventRecords, false));
            String gstl = "";
            for (Event e : allEvents) {
                gstl += (e.eventInformation() + "\n");
            }
            out_eventRec.write(gstl);
            out_eventRec.flush();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    private int getNewID() {//Returns a unique ID that will be used in implementations
        Random rn = new Random();
        ArrayList<Integer> ListOfIDs = new ArrayList<>();
        String line = "";
        for(Event e: allEvents)
        {
            ListOfIDs.add(e.getId());
        }
        int value = rn.nextInt(10000);
        while(ListOfIDs.contains(value))
            value = rn.nextInt();
        return value;
    }

    @Override
    public Iterator<Event> iterator() {
        return events.values().iterator();
    }
}
