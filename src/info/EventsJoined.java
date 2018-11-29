package info;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class EventsJoined implements Iterable<Event> {

    private ArrayList<Event> allEvents;
    private ArrayList<String> gstlist;
    private HashMap<Integer,Event> events;
    File eventRecords;
    BufferedReader in_events;
    PrintWriter out_eventRec;

    public EventsJoined(int user_id)
    {
         EventsBuilder eb = new EventsBuilder();
        events = new HashMap<>();
        allEvents = eb.getAllEvents();
        gstlist = new ArrayList<>();
        try{
            eventRecords = new File("src/info/eventFile/GuestList.txt");
            String line = "";
            in_events = new BufferedReader(new FileReader(eventRecords));
            while ((line = in_events.readLine()) != null) {
                gstlist.add(line);
                String[] main = line.split("--");
                String[] splitLine = main[1].split(",");
                for(int i=0;i<splitLine.length;i++)
                {
                    if(Integer.parseInt(splitLine[i])==user_id)
                    {
                        for(Event e: allEvents)
                        {
                            if(e.getId()==Integer.parseInt(splitLine[0]))
                                events.put(e.getId(),e);
                        }
                    }
                }
            }
            in_events.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void newEvent(int user_id, Event e)
    {
        EventsBuilder eb = new EventsBuilder();
        allEvents = eb.getAllEvents();
        gstlist.add(e.getId()+"--"+user_id);
        allEvents.add(e);
        events.put(e.getId(),e);
    }

    public void joinEvent(int user_id, Event e)
    {

        ArrayList<String> gues = new ArrayList<>();
        events.put(e.getId(),e);
        for(String s: gstlist)
        {
            String [] line = s.split("--");
            int eventCode = Integer.parseInt(line[0]);
            String guestList = line[1];
            if(e.getId()==eventCode)
            {
                guestList+=(","+user_id);
            }
            gues.add(line[0]+"--"+guestList);
        }
        gstlist = new ArrayList<>();
        gstlist = gues;
    }

    public void unJoinEvent(int user_id, Event e)
    {
        ArrayList<String> gues = new ArrayList<>();
        events.remove(e.getId());
        String gueste ="";
        for(String s: gstlist)
        {
            String [] line = s.split("--");
            String [] guests = line[1].split(",");
            String str = line[0]+"--"+guests[0];
            if(Integer.parseInt(line[0])==e.getId())
            {
                for(int i=1;i<guests.length;i++)
                {
                    if(Integer.parseInt(guests[i])!=user_id)
                        str += (","+guests[i]);
                }
                gueste = str;
            }
            else
            {
                gueste = s;
            }
            gues.add(gueste);
        }
        gstlist = gues;
    }

    public ArrayList<String> guestListEvent(int eventID)
    {
        ArrayList<String> str = new ArrayList<>();
        try {
            eventRecords = new File("src/info/dataFile/NameRecords.txt");
            String line = "";
            in_events = new BufferedReader(new FileReader(eventRecords));
            while ((line = in_events.readLine()) != null) {
                String[] user = line.split(",");
                for(String s: gstlist) {
                    String[] main = s.split("--");
                    String[] splitLine = main[1].split(",");
                    for(String st: splitLine)
                    {
                        if(st.equals(user[0]))
                        {
                            str.add(user[1]);
                        }
                    }
                }
            }
            return str;
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public void removedEvent(int user_id,Event event)
    {
        ArrayList<String> est = new ArrayList<>();
        for(String s: gstlist)
        {
            String [] line = s.split("--");
            if(Integer.parseInt(line[0])!=event.getId())
            {
                est.add(s);
            }
        }
        gstlist = est;
    }

    public void rewriteGuests()
    {
        try {
            out_eventRec = new PrintWriter(new FileOutputStream(eventRecords, false));
            String gstl = "";
            for (String s : gstlist) {
                gstl += (s + "\n");
            }
            out_eventRec.write(gstl);
            out_eventRec.flush();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }


    @Override
    public Iterator<Event> iterator() {
        return events.values().iterator();
    }
}
