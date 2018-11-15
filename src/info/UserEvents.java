package info;

import java.util.ArrayList;
import java.util.HashSet;

public class UserEvents implements EventList{

    User mainUser;
    EventMaker eventMaker; //R/W applet
    ArrayList<Event> createdEvents = new ArrayList<>();

    public UserEvents(User user,ArrayList<Event> events)
    {
        mainUser = user;
        createdEvents = events;
    }

    public void loadEvent()
    {
        HashSet<Event> event = eventMaker.loadEvents(mainUser);
        for (Event e:event) {
            createdEvents.add(e);
        }
    }

    public void addEvent(Event event)
    {
        createdEvents.add(event);
    }
    public void removeEvent(Event event)
    {
        createdEvents.remove(event);
    }

    @Override
    public void displayEvents() {
        System.out.println("This is a user event: "+this.toString());
    }
}
