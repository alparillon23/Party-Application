package info;

import java.io.*;
import java.util.ArrayList;

public class EventsBuilder {

    ArrayList<Event> allEvents;
    File eventRecords;
    BufferedReader in_events;
    PrintWriter out_eventRec;

    public EventsBuilder() {
        allEvents = new ArrayList<>();
        try {
            eventRecords = new File("src/info/eventFile/EventsRecords.txt");
            String line = "";
            in_events = new BufferedReader(new FileReader(eventRecords));
            while ((line = in_events.readLine()) != null) {
                String[] splitLine = line.split(",");
                Event event = new Event(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]), splitLine[2], splitLine[3], splitLine[4], splitLine[5]);
                allEvents.add(event);
            }
            in_events.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<Event> getAllEvents() {
        return allEvents;
    }

    public void addEvent(Event e)
    {
        allEvents.add(e);
    }

    public void rewriteEvent()
    {
        try {
            out_eventRec = new PrintWriter(new FileOutputStream(eventRecords, false));
            String eventRec = "";
            for (Event e : allEvents) {
                eventRec += (e.eventInformation() + "\n");
            }
            out_eventRec.write(eventRec);
            out_eventRec.flush();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void replaceEvent(Event e)
    {
        ArrayList<Event> events = new ArrayList<>();
        for(Event ee: allEvents)
        {
            if(ee.getId()!=e.getId())
                events.add(ee);
        }
        events.add(e);
        allEvents = new ArrayList<>();
        allEvents = events;
    }

    public void removeEvent(Event e)
    {
        ArrayList<Event> events = new ArrayList<>();
        for(Event ee: allEvents)
        {
            if(ee.getId()!=e.getId())
                events.add(ee);
        }
        allEvents = new ArrayList<>();
        allEvents = events;
    }
}
